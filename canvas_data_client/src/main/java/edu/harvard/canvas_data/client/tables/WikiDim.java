package edu.harvard.canvas_data.client.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class WikiDim extends CanvasDataTable {
  private Long id;
  private Long canvasId;
  private String parentType;
  private String title;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
  private String frontPageUrl;
  private Boolean hasNoFrontPage;

  public WikiDim(final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    this.parentType = record.get(2);
    this.title = record.get(3);
    String $createdAt = record.get(4);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $updatedAt = record.get(5);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    this.frontPageUrl = record.get(6);
    String $hasNoFrontPage = record.get(7);
    if ($hasNoFrontPage != null && $hasNoFrontPage.length() > 0) {
      this.hasNoFrontPage = Boolean.valueOf($hasNoFrontPage);
    }
  }

  public Long getId() {
    return this.id;
  }

  public Long getCanvasId() {
    return this.canvasId;
  }

  public String getParentType() {
    return this.parentType;
  }

  public String getTitle() {
    return this.title;
  }

  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public String getFrontPageUrl() {
    return this.frontPageUrl;
  }

  public Boolean getHasNoFrontPage() {
    return this.hasNoFrontPage;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(parentType);
    fields.add(title);
    fields.add(formatTimestamp(createdAt));
    fields.add(formatTimestamp(updatedAt));
    fields.add(frontPageUrl);
    fields.add(hasNoFrontPage);
    return fields;
  }

  @Override
  public List<String> getCsvHeaders() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("parent_type");
      fields.add("title");
      fields.add("created_at");
      fields.add("updated_at");
      fields.add("front_page_url");
      fields.add("has_no_front_page");
    return fields;
  }
}
