package edu.harvard.data.client.canvas.tables;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.TableFormat;

public class PseudonymFact implements DataTable {
  private Long pseudonymId;
  private Long userId;
  private Long accountId;
  private Integer loginCount;
  private Integer failedLoginCount;

  public PseudonymFact(final TableFormat format, final CSVRecord record) {
    String $pseudonymId = record.get(0);
    if ($pseudonymId != null && $pseudonymId.length() > 0) {
      this.pseudonymId = Long.valueOf($pseudonymId);
    }
    String $userId = record.get(1);
    if ($userId != null && $userId.length() > 0) {
      this.userId = Long.valueOf($userId);
    }
    String $accountId = record.get(2);
    if ($accountId != null && $accountId.length() > 0) {
      this.accountId = Long.valueOf($accountId);
    }
    String $loginCount = record.get(3);
    if ($loginCount != null && $loginCount.length() > 0) {
      this.loginCount = Integer.valueOf($loginCount);
    }
    String $failedLoginCount = record.get(4);
    if ($failedLoginCount != null && $failedLoginCount.length() > 0) {
      this.failedLoginCount = Integer.valueOf($failedLoginCount);
    }
  }

  public Long getPseudonymId() {
    return this.pseudonymId;
  }

  public Long getUserId() {
    return this.userId;
  }

  public Long getAccountId() {
    return this.accountId;
  }

  public Integer getLoginCount() {
    return this.loginCount;
  }

  public Integer getFailedLoginCount() {
    return this.failedLoginCount;
  }

  @Override
  public List<Object> getFieldsAsList(final TableFormat formatter) {
    final List<Object> fields = new ArrayList<Object>();
    fields.add(pseudonymId);
    fields.add(userId);
    fields.add(accountId);
    fields.add(loginCount);
    fields.add(failedLoginCount);
    return fields;
  }

  public static List<String> getFieldNames() {
    final List<String> fields = new ArrayList<String>();
      fields.add("pseudonym_id");
      fields.add("user_id");
      fields.add("account_id");
      fields.add("login_count");
      fields.add("failed_login_count");
    return fields;
  }
}
