package edu.harvard.canvas_data.parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.util.Properties;

public class Configuration {

  private String canvasApiKey;
  private String canvasApiSecret;
  private String canvasDataHost;
  private Path canvasDataScratchDirectory;
  private Path canvasDataArchiveDirectory;

  public static Configuration getConfiguration(final String propertiesFileName) throws IOException {
    final ClassLoader cl = Configuration.class.getClassLoader();
    Properties properties;
    try (final InputStream in = cl.getResourceAsStream(propertiesFileName)) {
      if (in == null) {
        throw new FileNotFoundException(propertiesFileName);
      }
      properties = new Properties();
      properties.load(in);
    }
    final Configuration config = new Configuration();
    config.canvasApiKey = getConfigParameter(properties, "canvas_data_api_key");
    config.canvasApiSecret = getConfigParameter(properties, "canvas_data_api_secret");
    config.canvasDataHost = getConfigParameter(properties, "canvas_data_host");
    final String scratch = getConfigParameter(properties, "canvas_data_scratch_directory");
    config.canvasDataScratchDirectory = Paths.get(scratch);
    final String archive = getConfigParameter(properties, "canvas_data_archive_directory");
    config.canvasDataArchiveDirectory = Paths.get(archive);
    return config;
  }

  private static String getConfigParameter(final Properties properties, final String key) {
    final String param = (String) properties.get(key);
    if (param == null) {
      throw new InvalidParameterException("Configuration file missing " + key);
    }
    return param;
  }

  private Configuration() {
  }

  public String getCanvasApiKey() {
    return canvasApiKey;
  }

  public String getCanvasApiSecret() {
    return canvasApiSecret;
  }

  public String getCanvasDataHost() {
    return canvasDataHost;
  }

  public Path getCanvasDataScratchDirectory() {
    return canvasDataScratchDirectory;
  }

  public Path getCanvasDataArchiveDirectory() {
    return canvasDataArchiveDirectory;
  }

}
