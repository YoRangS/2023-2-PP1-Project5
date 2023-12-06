package com.example;

import java.util.List;

public interface AlbumService {
    public int insertAlbum(AlbumVO vo);
    public int deleteAlbum(int ID);
    public int updateAlbum(AlbumVO vo);
    public AlbumVO getAlbum(int ID);
    public List<AlbumVO> getAlbumList();
}
