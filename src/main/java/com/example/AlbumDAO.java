package com.example;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

class AlbumRowMapper implements RowMapper<AlbumVO> {
    @Override
    public AlbumVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        AlbumVO vo = new AlbumVO();
        vo.setID(rs.getInt("ID"));
        vo.setName(rs.getString("Name"));
        vo.setArtist(rs.getString("Artist"));
        vo.setSongAmount(rs.getInt("SongAmount"));
        vo.setLikes(rs.getInt("Likes"));
        vo.setRegDate(rs.getDate("RegDate"));
        vo.setDibs(rs.getBoolean("Dibs"));
//        System.out.println("Dibssss : " + rs.getBoolean("Dibs"));
        return vo;
    }
}

@Repository
public class AlbumDAO {

    @Autowired
    SqlSession sqlSession;

    public int insertALBUM(AlbumVO vo) {
        System.out.println("===> Mapper로 insertALBUM() 기능 처리");
        if(vo.getDibs() != null) vo.setDibs(true);
        else vo.setDibs(false);
        int result = sqlSession.insert("Album.insertALBUM", vo);
        return result;
    }

    // 글 삭제
    public int deleteALBUM(int id) {
        System.out.println("===> Mapper로 deleteALBUM() 기능 처리");
        int result = sqlSession.delete("Album.deleteALBUM", id);
        return result;
    }
    public int updateALBUM(AlbumVO vo) {
        System.out.println("===> Mapper로 updateALBUM() 기능 처리");
        int result = sqlSession.update("Album.updateALBUM", vo);
        return result;
    }

    public AlbumVO getALBUM(int ID) {
        System.out.println("===> Mapper로 getALBUM() 기능 처리");
        AlbumVO one = sqlSession.selectOne("Album.getALBUM", ID);
        return one;
    }

    public List<AlbumVO> getALBUMList(){
        System.out.println("===> Mapper로 getALBUMList() 기능 처리");
        List<AlbumVO> list = sqlSession.selectList("Album.getALBUMList");
        return list;
    }
}