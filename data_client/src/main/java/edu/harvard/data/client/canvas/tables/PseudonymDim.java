// This file was generated on 29-10-2015 01:16:10. Do not manually edit. 
// This class is based on Version 1.0.0 of the Canvas Data schema 

package edu.harvard.data.client.canvas.tables;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class PseudonymDim implements DataTable {
  private Long id;
  private Long canvasId;
  private Long userId;
  private Long accountId;
  private String workflowState;
  private ZonedDateTime lastRequestAt;
  private ZonedDateTime lastLoginAt;
  private ZonedDateTime currentLoginAt;
  private String lastLoginIp;
  private String currentLoginIp;
  private Integer position;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
  private Boolean passwordAutoGenerated;
  private ZonedDateTime deletedAt;
  private String sisUserId;
  private String uniqueName;

  public PseudonymDim(final TableFormat format, final CSVRecord record) {
    String $id = record.get(0);
    if ($id != null && $id.length() > 0) {
      this.id = Long.valueOf($id);
    }
    String $canvasId = record.get(1);
    if ($canvasId != null && $canvasId.length() > 0) {
      this.canvasId = Long.valueOf($canvasId);
    }
    String $userId = record.get(2);
    if ($userId != null && $userId.length() > 0) {
      this.userId = Long.valueOf($userId);
    }
    String $accountId = record.get(3);
    if ($accountId != null && $accountId.length() > 0) {
      this.accountId = Long.valueOf($accountId);
    }
    this.workflowState = record.get(4);
    String $lastRequestAt = record.get(5);
    if ($lastRequestAt != null && $lastRequestAt.length() > 0) {
      this.lastRequestAt = ZonedDateTime.parse($lastRequestAt, format.getTimstampFormat());
    }
    String $lastLoginAt = record.get(6);
    if ($lastLoginAt != null && $lastLoginAt.length() > 0) {
      this.lastLoginAt = ZonedDateTime.parse($lastLoginAt, format.getTimstampFormat());
    }
    String $currentLoginAt = record.get(7);
    if ($currentLoginAt != null && $currentLoginAt.length() > 0) {
      this.currentLoginAt = ZonedDateTime.parse($currentLoginAt, format.getTimstampFormat());
    }
    this.lastLoginIp = record.get(8);
    this.currentLoginIp = record.get(9);
    String $position = record.get(10);
    if ($position != null && $position.length() > 0) {
      this.position = Integer.valueOf($position);
    }
    String $createdAt = record.get(11);
    if ($createdAt != null && $createdAt.length() > 0) {
      this.createdAt = ZonedDateTime.parse($createdAt, format.getTimstampFormat());
    }
    String $updatedAt = record.get(12);
    if ($updatedAt != null && $updatedAt.length() > 0) {
      this.updatedAt = ZonedDateTime.parse($updatedAt, format.getTimstampFormat());
    }
    String $passwordAutoGenerated = record.get(13);
    if ($passwordAutoGenerated != null && $passwordAutoGenerated.length() > 0) {
      this.passwordAutoGenerated = Boolean.valueOf($passwordAutoGenerated);
    }
    String $deletedAt = record.get(14);
    if ($deletedAt != null && $deletedAt.length() > 0) {
      this.deletedAt = ZonedDateTime.parse($deletedAt, format.getTimstampFormat());
    }
    this.sisUserId = record.get(15);
    this.uniqueName = record.get(16);
  }

  /**
   * Unique surrogate id for the pseudonym. 
   */
  public Long getId() {
    return this.id;
  }

  /**
   * Primary key for this pseudonym in the the Canvas database 
   */
  public Long getCanvasId() {
    return this.canvasId;
  }

  /**
   * Id for the user associated with this pseudonym 
   */
  public Long getUserId() {
    return this.userId;
  }

  /**
   * Id for the account associated with this pseudonym 
   */
  public Long getAccountId() {
    return this.accountId;
  }

  /**
   * Workflow status indicating that pseudonym is [deleted] or [active] 
   */
  public String getWorkflowState() {
    return this.workflowState;
  }

  /**
   * tbd 
   */
  public ZonedDateTime getLastRequestAt() {
    return this.lastRequestAt;
  }

  /**
   * Timestamp of last time a user logged in with this pseudonym 
   */
  public ZonedDateTime getLastLoginAt() {
    return this.lastLoginAt;
  }

  /**
   * tbd 
   */
  public ZonedDateTime getCurrentLoginAt() {
    return this.currentLoginAt;
  }

  /**
   * IP address recorded the last time a user logged in with thisi pseudonym 
   */
  public String getLastLoginIp() {
    return this.lastLoginIp;
  }

  /**
   * tbd 
   */
  public String getCurrentLoginIp() {
    return this.currentLoginIp;
  }

  /**
   * tbd 
   */
  public Integer getPosition() {
    return this.position;
  }

  /**
   * Timestamp when this pseudonym was created in Canvas 
   */
  public ZonedDateTime getCreatedAt() {
    return this.createdAt;
  }

  /**
   * Timestamp when this pseudonym was last updated in Canvas 
   */
  public ZonedDateTime getUpdatedAt() {
    return this.updatedAt;
  }

  /**
   * True if the password has been autogenerated 
   */
  public Boolean getPasswordAutoGenerated() {
    return this.passwordAutoGenerated;
  }

  /**
   * Timestamp when the pseudonym was deleted (NULL if the pseudonym is still 
   * active) 
   */
  public ZonedDateTime getDeletedAt() {
    return this.deletedAt;
  }

  /**
   * Correlated id for the record for this course in the SIS system (assuming 
   * SIS integration is configured) 
   */
  public String getSisUserId() {
    return this.sisUserId;
  }

  /**
   * Actual login id for a given pseudonym/account 
   */
  public String getUniqueName() {
    return this.uniqueName;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(id);
    fields.add(canvasId);
    fields.add(userId);
    fields.add(accountId);
    fields.add(workflowState);
    fields.add(formatter.formatTimestamp(lastRequestAt));
    fields.add(formatter.formatTimestamp(lastLoginAt));
    fields.add(formatter.formatTimestamp(currentLoginAt));
    fields.add(lastLoginIp);
    fields.add(currentLoginIp);
    fields.add(position);
    fields.add(formatter.formatTimestamp(createdAt));
    fields.add(formatter.formatTimestamp(updatedAt));
    fields.add(passwordAutoGenerated);
    fields.add(formatter.formatTimestamp(deletedAt));
    fields.add(sisUserId);
    fields.add(uniqueName);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("id");
      fields.add("canvas_id");
      fields.add("user_id");
      fields.add("account_id");
      fields.add("workflow_state");
      fields.add("last_request_at");
      fields.add("last_login_at");
      fields.add("current_login_at");
      fields.add("last_login_ip");
      fields.add("current_login_ip");
      fields.add("position");
      fields.add("created_at");
      fields.add("updated_at");
      fields.add("password_auto_generated");
      fields.add("deleted_at");
      fields.add("sis_user_id");
      fields.add("unique_name");
    return fields;
  }
}
