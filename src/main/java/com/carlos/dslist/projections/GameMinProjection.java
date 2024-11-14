package com.carlos.dslist.projections;

public interface GameMinProjection {
    Long getId();
    String getTitle();
    Integer getGameYear();
    String getImgUrl();
    String getShortDescription();
    String getLongDescription();
    Integer GetPosition();
}
