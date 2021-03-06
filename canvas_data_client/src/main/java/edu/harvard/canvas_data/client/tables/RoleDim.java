package edu.harvard.canvas_data.client.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public class RoleDim extends CanvasDataTable {
  private Long id;
  private Long canvasId;
  private Long rootAccountId;
  private Long accountId;
  private String name;
  private String baseRoleType;
  private String workflowState;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
  private ZonedDateTime deletedAt;

  public RoleDim(final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    String $rootAccountId = record.get(2);
    if ($rootAccountId != null && $rootAccountId.length() > 0) {
      this.rootAccountId = Long.valueOf($rootAccountId);
    }
    String $accountId = record.get(3);
    if ($accountId != null && $accountId.length() > 0) {
      this.accountId = Long.valueOf($accountId);
    }
    this.name = record.get(4);
    this.baseRoleType = record.get(5);
    this.workflowState = record.get(6);
    String $createdAt = record.get(7);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $updatedAt = record.get(8);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
    String $deletedAt = record.get(9);
    if ($deletedAt != null && $deletedAt.length() > 0) {
      this.deletedAt = ZonedDateTime.parse($deletedAt, CANVAS_DATA_TIMESTAMP_FORMAT);
    }
  }

  public Long getId() {
    return this.id;
  }

  public Long getCanvasId() {
    return this.canvasId;
  }

  public Long getRootAccountId() {
    return this.rootAccountId;
  }

  public Long getAccountId() {
    return this.accountId;
  }

  public String getName() {
    return this.name;
  }

  public String getBaseRoleType() {
    return this.baseRoleType;
  }

  public String getWorkflowState() {
    return this.workflowState;
  }

  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public ZonedDateTime getDeletedAt() {
    return this.deletedAt;
  }

  @Override
    public List<Object> getCsvFields() {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(rootAccountId);
    fields.add(accountId);
    fields.add(name);
    fields.add(baseRoleType);
    fields.add(workflowState);
    fields.add(formatTimestamp(createdAt));
    fields.add(formatTimestamp(updatedAt));
    fields.add(formatTimestamp(deletedAt));
    return fields;
  }

  @Override
  public List<String> getCsvHeaders() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("root_account_id");
      fields.add("account_id");
      fields.add("name");
      fields.add("base_role_type");
      fields.add("workflow_state");
      fields.add("created_at");
      fields.add("updated_at");
      fields.add("deleted_at");
    return fields;
  }
}
