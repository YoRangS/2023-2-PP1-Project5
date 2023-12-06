package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    AlbumDAO albumDAO;

    @Override
    public int insertAlbum(AlbumVO vo) {
        return albumDAO.insertALBUM(vo);
    }

    @Override
    public int deleteAlbum(int ID) {
        return albumDAO.deleteALBUM(ID);
    }

    @Override
    public int updateAlbum(AlbumVO vo) {
        return albumDAO.updateALBUM(vo);
    }

    @Override
    public AlbumVO getAlbum(int ID) {
        return albumDAO.getALBUM(ID);
    }

    @Override
    public List<AlbumVO> getAlbumList() {
        return albumDAO.getALBUMList();
    }
}
