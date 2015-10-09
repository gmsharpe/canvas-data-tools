package edu.harvard.canvas_data.cli.analysis;

import java.io.IOException;
import java.io.PrintStream;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.spi.SubCommand;
import org.kohsuke.args4j.spi.SubCommandHandler;
import org.kohsuke.args4j.spi.SubCommands;

import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.cli.ReturnStatus;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.canvas.api.UnexpectedApiResponseException;

public class AnalysisCommandGroup implements Command {

  @Argument(handler = SubCommandHandler.class, usage = "Analysis job commands.")
  @SubCommands({ @SubCommand(name = "requests", impl = RequestHistogramCommand.class) })
  public Command cmd;

  @Override
  public ReturnStatus execute(final Configuration config, final PrintStream out)
      throws DataConfigurationException, IOException, UnexpectedApiResponseException {
    return cmd.execute(config, out);
  }

  @Override
  public String getDescription() {
    return "Data analysis sub-commands";
  }

}
