package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

import com.example.util.JDBCUtil;
import com.example.bean.AlbumVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
        return vo;
    }
}

@Repository
public class AlbumDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    private final String ALBUM_INSERT = "insert into albumlist (Name, Artist, SongAmount, Likes, RegDate, Dibs) values (?,?,?,?,?,?)";
    private final String ALBUM_UPDATE = "update albumlist set Name=?, Artist=?, SongAmount=?, Likes=?, RegDate=? Dibs=? where ID=?";
    private final String ALBUM_DELETE = "delete from albumlist where ID=?";
    private final String ALBUM_GET = "select * from albumlist where ID=?";
    private final String ALBUM_LIST = "select * from albumlist order by ID desc";

    public int insertALBUM(AlbumVO vo) {
        System.out.println("===> JDBC로 insertALBUM() 기능 처리");
        System.out.println("Name: " + vo.getName() + "\tArtist:" + vo.getArtist() + "\tSongAmount:" + vo.getSongAmount() + "\tLikes:" + vo.getLikes());
        String sql = "insert into albumlist (Name, Artist, SongAmount, Likes, RegDate, Dibs) values ("
                + "'" + vo.getName() + "',"
                + "'" + vo.getArtist() + "',"
                + "" + vo.getSongAmount() + ","
                + "" + vo.getLikes() + ","
                + "'" + vo.getRegDate() + "',"
                + "'" + vo.getDibs() + "'";
        return jdbcTemplate.update(sql);
    }

    // 글 삭제
    public int deleteALBUM(int id) {
        System.out.println("===> JDBC로 deleteALBUM() 기능 처리");
        String sql = "delete from albumlist where ID='" + id;
        return jdbcTemplate.update(sql);
    }
    public int updateALBUM(AlbumVO vo) {
        System.out.println("===> JDBC로 updateALBUM() 기능 처리");
        String sql = "update albumlist set Name='" + vo.getName() + "',"
                + "Artist='" + vo.getArtist() + "',"
                + "SongAmount='" + vo.getSongAmount() + "',"
                + "Likes='" + vo.getLikes() + "',"
                + "RegDate='" + vo.getRegDate() + "',"
                + "Dibs='" + vo.getDibs() + "' where ID=" + vo.getID();
        return jdbcTemplate.update(sql);
    }

    public AlbumVO getALBUM(int ID) {
        System.out.println("===> JDBC로 getALBUM() 기능 처리");
        String sql = "select * from albumlist where ID=" + ID;
        return jdbcTemplate.queryForObject(sql, new AlbumRowMapper());
    }

    public List<AlbumVO> getALBUMList(){
        System.out.println("===> JDBC로 getALBUMList() 기능 처리");
        String sql = "select * from albumlist order by ID desc";
        return jdbcTemplate.query(sql, new AlbumRowMapper());
    }
}