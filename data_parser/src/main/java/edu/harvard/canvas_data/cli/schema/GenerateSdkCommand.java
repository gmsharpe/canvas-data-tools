package edu.harvard.canvas_data.cli.schema;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.cli.ReturnStatus;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataClient;
import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.canvas.api.CanvasApiClient;
import edu.harvard.data.client.canvas.api.CanvasDataSchema;
import edu.harvard.data.client.canvas.api.UnexpectedApiResponseException;
import edu.harvard.data.client.generators.JavaSdkGenerator;

public class GenerateSdkCommand implements Command {

  @Argument(index = 0, usage = "Schema version, or LATEST. If not supplied, a file must be specified using -f.", metaVar = "1.0.0", required = false)
  private String version;

  @Option(name = "-f", usage = "JSON file containing a schema object.", metaVar = "/path/to/file.json")
  private File file;

  @Option(name = "-o", usage = "Base directory to put the source code.", metaVar = "/path/to/dir", required = true)
  private File output;

  @Override
  public ReturnStatus execute(final Configuration config, final PrintStream out)
      throws DataConfigurationException, IOException, UnexpectedApiResponseException {
    final CanvasApiClient api = new DataClient().getCanvasApiClient(config.getCanvasDataHost(),
        config.getCanvasApiKey(), config.getCanvasApiSecret());
    final ObjectMapper mapper = new ObjectMapper();
    final CanvasDataSchema schema;
    if (version != null) {
      schema = api.getSchema(version);
    } else {
      if (file == null) {
        throw new IllegalArgumentException("Either schema version or a file name is required.");
      }
      if (!file.exists() || file.isDirectory()) {
        throw new IllegalArgumentException(file + " is not a valid JSON file.");
      }
      schema = mapper.readValue(file, CanvasDataSchema.class);
    }

    final JavaSdkGenerator generator = new JavaSdkGenerator(schema);
    generator.generate(output.toPath());

    return ReturnStatus.OK;
  }

  @Override
  public String getDescription() {
    return "Output a specific version of the data schema to standard out.";
  }

}