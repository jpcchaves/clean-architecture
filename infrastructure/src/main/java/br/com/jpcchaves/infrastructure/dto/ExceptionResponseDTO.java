package br.com.jpcchaves.infrastructure.dto;

import java.util.Date;

public class ExceptionResponseDTO {
  private Date date;
  private String message;
  private String description;

  public ExceptionResponseDTO(Date date, String message, String description) {
    this.date = date;
    this.message = message;
    this.description = description;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
