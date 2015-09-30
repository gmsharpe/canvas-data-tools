package edu.harvard.canvas_data.cli.dataset;

import java.io.File;
import java.io.IOException;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

import edu.harvard.canvas_data.DataPartitioner;
import edu.harvard.canvas_data.DataSetUtils;
import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.DataSetReader;

public class SplitRequestsCommand implements Command {

  @Argument(index = 0,
      usage = "Input Data Set (either a directory or LATEST). This argument is required",
      metaVar = "/path/to/directory", required = true)
  private String input;

  @Argument(index = 1, usage = "Output Data set directory. This argument is required",
      metaVar = "/path/to/directory", required = true)
  private File output;

  @Option(name = "-a", usage = "Axis to split the data set. Defaults to class.",
      metaVar = "class|day")
  private String axis;

  @Option(name = "-f", usage = "Format for the new data set", metaVar = "format")
  private String format;

  @Override
  public void execute(final Configuration config) throws DataConfigurationException, IOException {
    final DataSetUtils utils = new DataSetUtils(config);
    final DataSetReader in = utils.getReaderFromString(input);
    if (axis == null) {
      axis = "class";
    }
    try {
      final DataPartitioner partitioner = new DataPartitioner(in, output.toPath());

      switch(axis) {
      case "day":
        partitioner.splitRequestsByDay();
        break;
      case "class":
        partitioner.splitRequestsByCourse();
        break;
      default:
        throw new RuntimeException("Split axis must be either 'class' or 'day'");
      }
    } finally {
      in.close();
    }
  }

  @Override
  public String getDescription() {
    return "Copy all requests records into new datasets according to some criteria.";
  }

}