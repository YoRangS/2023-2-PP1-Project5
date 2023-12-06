package com.example;

import java.sql.Date;

public class AlbumVO {
    private int ID;
    private String Name;
    private String Artist;
    private int SongAmount;
    private int Likes;
    private Date RegDate;
    private Boolean Dibs;
    // TODO: Image init


    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }
    public String getName() { return Name; }
    public void setName(String Name) { this.Name = Name; }
    public String getArtist() { return Artist; }
    public void setArtist(String Artist) { this.Artist = Artist; }
    public int getSongAmount() { return SongAmount; }
    public void setSongAmount(int SongAmount) { this.SongAmount = SongAmount; }
    public int getLikes() { return Likes; }
    public void setLikes(int Likes) { this.Likes = Likes; }
    public Date getRegDate() {return RegDate;}
    public void setRegDate(Date regDate) {RegDate = regDate;}
    public Boolean getDibs() {return Dibs;}
    public void setDibs(Boolean dibs) {Dibs = dibs;}
}