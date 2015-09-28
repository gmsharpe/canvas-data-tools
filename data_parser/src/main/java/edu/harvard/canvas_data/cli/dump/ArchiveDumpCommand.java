package edu.harvard.canvas_data.cli.dump;

import java.io.File;
import java.io.IOException;

import org.kohsuke.args4j.Option;

import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.canvas_data.parser.DumpManager;
import edu.harvard.data.client.DataClient;
import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.canvas.api.CanvasApiClient;
import edu.harvard.data.client.canvas.api.CanvasDataDump;
import edu.harvard.data.client.canvas.api.UnexpectedApiResponseException;

public class ArchiveDumpCommand implements Command {

  @Option(name = "-i", usage = "Dump ID. Either this or the dump sequence number is required",
      metaVar = "dump_id", forbids = {"-s" })
  private String id;

  @Option(name = "-s", usage = "Dump sequence number. Either this or the dump ID is required.",
      metaVar = "sequence_number", forbids = {"-i" })
  private String seq;

  @Option(name = "-d", usage = "Input directory. Defaults to the scratch directory.",
      metaVar = "/path/to/directory")
  private File directory;

  @Override
  public void execute(final Configuration config) throws IOException, DataConfigurationException {
    try {
      final CanvasApiClient api = new DataClient().getCanvasApiClient(config.getCanvasDataHost(),
          config.getCanvasApiKey(), config.getCanvasApiSecret());
      final CanvasDataDump dump;
      final DumpManager manager = new DumpManager(config);
      if (id != null) {
        dump = api.getDump(id);
        if (dump == null) {
          System.err.println("Dump ID " + id + " is not available");
          return;
        }
      } else if (seq != null) {
        dump = getDumpForSequence(api);
        if (dump == null) {
          System.err.println("Dump sequence " + seq + " is not available");
          return;
        }
      } else {
        System.err.println("Either dump ID or sequence number is required.");
        return;
      }
      if (directory == null) {
        directory = manager.getScratchDumpDir(dump).toFile();
      }
      if (!manager.isValidDumpDirectory(directory.toPath())) {
        System.err.println(directory + " is not a valid Canvas data dump");
      }
      manager.archiveDump(directory.toPath(), manager.getArchiveDumpDir(dump));
    } catch (final UnexpectedApiResponseException e) {
      e.printStackTrace();
    }
  }

  CanvasDataDump getDumpForSequence(final CanvasApiClient api)
      throws DataConfigurationException, UnexpectedApiResponseException {
    for (final CanvasDataDump d : api.getDumps()) {
      if (("" + d.getSequence()).equals(seq)) {
        return api.getDump(d.getDumpId());
      }
    }
    return null;
  }

  @Override
  public String getDescription() {
    return "Move a dump from a given directory to the archive directory.";
  }

}