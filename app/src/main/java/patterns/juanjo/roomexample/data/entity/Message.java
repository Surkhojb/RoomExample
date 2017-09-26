package patterns.juanjo.roomexample.data.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import java.util.UUID;

/**
 * Created by juanj on 25/09/2017.
 */

@Entity
public class Message {
  @PrimaryKey
  String id;
  String title;
  String message;
  String timeOfDay;

  int color;

  public Message(String title, String message, String timeOfDay,int color) {
    this.id = UUID.randomUUID().toString();
    this.title = title;
    this.timeOfDay = timeOfDay;
    this.message = message;
    this.color = color;
  }

  public String getTitle() {
    return title;
  }

  public String getTimeOfDay() {
    return timeOfDay;
  }

  public String getMessage() {
    return message;
  }

  public int getColor() {
    return color;
  }
}
