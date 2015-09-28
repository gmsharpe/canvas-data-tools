package edu.harvard.data.client;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.csv.CSVFormat;

public class TableFormat implements Cloneable {

  public enum Compression { None, Gzip };

  private DateTimeFormatter timestampFormat;
  private DateTimeFormatter dateFormat;
  private boolean includeHeaders;
  private String encoding;
  private CSVFormat csvFormat;
  private Compression compression;

  public TableFormat() {
    this.timestampFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm'Z'");
    this.dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    this.includeHeaders = true;
    this.encoding = "UTF-8";
    this.csvFormat = CSVFormat.DEFAULT;
    this.compression = Compression.None;
  }

  public DateTimeFormatter getTimstampFormat() {
    return timestampFormat;
  }

  public DateTimeFormatter getDateFormat() {
    return dateFormat;
  }

  public String getEncoding() {
    return encoding;
  }

  public CSVFormat getCsvFormat() {
    return csvFormat;
  }

  public boolean includeHeaders() {
    return includeHeaders;
  }

  public Compression getCompression() {
    return compression;
  }

  public void setTimestampFormat(final DateTimeFormatter timestampFormat) {
    this.timestampFormat = timestampFormat;
  }

  public void setDateFormat(final DateTimeFormatter dateFormat) {
    this.dateFormat = dateFormat;
  }

  public void setIncludeHeaders(final boolean includeHeaders) {
    this.includeHeaders = includeHeaders;
  }

  public void setEncoding(final String encoding) {
    this.encoding = encoding;
  }

  public void setCsvFormat(final CSVFormat csvFormat) {
    this.csvFormat = csvFormat;
  }

  public void setCompression(final Compression compression) {
    this.compression = compression;
  }

  public String formatTimestamp(final LocalDate date) {
    if (date == null) {
      return null;
    }
    return date.format(getDateFormat());
  }

  public String formatTimestamp(final ZonedDateTime time) {
    if (time == null) {
      return null;
    }
    String timestamp = time.format(getTimstampFormat());
    if (timestamp.endsWith(".0")) {
      timestamp = timestamp.substring(0, timestamp.lastIndexOf("."));
    }
    return timestamp;
  }

  @Override
  public Object clone() {
    final TableFormat other = new TableFormat();
    other.compression = compression;
    other.csvFormat = csvFormat;
    other.dateFormat = dateFormat;
    other.encoding = encoding;
    other.includeHeaders = includeHeaders;
    other.timestampFormat = timestampFormat;
    return other;
  }
}