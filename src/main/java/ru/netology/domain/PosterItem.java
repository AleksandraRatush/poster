package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class PosterItem {
  private int id;
  private String name;
  private String genre;
  private String picUrl;
  private boolean isFirstNight;
}
