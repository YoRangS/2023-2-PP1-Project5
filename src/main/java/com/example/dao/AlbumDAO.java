package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.util.JDBCUtil;
import com.example.bean.AlbumVO;

public class AlbumDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    private final String MUSIC_INSERT = "insert into songlist (Name, Artist, SongAmount, Likes, RegDate, Dibs) values (?,?,?,?,?,?)";
    private final String MUSIC_UPDATE = "update songlist set Name=?, Artist=?, SongAmount=?, Likes=?, RegDate=? Dibs=? where ID=?";
    private final String MUSIC_DELETE = "delete from songlist where ID=?";
    private final String MUSIC_GET = "select * from songlist where ID=?";
    private final String MUSIC_LIST = "select * from songlist order by ID desc";

    public int insertMusic(AlbumVO vo) {
        System.out.println("===> JDBC로 insertMusic() 기능 처리");
        System.out.println("Name: " + vo.getName() + "\tArtist:" + vo.getArtist() + "\tSongAmount:" + vo.getSongAmount() + "\tLikes:" + vo.getLikes());
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MUSIC_INSERT);
            stmt.setString(1, vo.getName());
            stmt.setString(2, vo.getArtist());
            stmt.setInt(3, vo.getSongAmount());
            stmt.setInt(4, vo.getLikes());
            stmt.setDate(5, vo.getRegDate());
            stmt.setBoolean(6, vo.getDibs());
            stmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 글 삭제
    public void deleteMusic(AlbumVO vo) {
        System.out.println("===> JDBC로 deleteMusic() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MUSIC_DELETE);
            stmt.setInt(1, vo.getID());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int updateMusic(AlbumVO vo) {
        System.out.println("===> JDBC로 updateMusic() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MUSIC_UPDATE);
            stmt.setString(1, vo.getName());
            stmt.setString(2, vo.getArtist());
            stmt.setInt(3, vo.getSongAmount());
            stmt.setInt(4, vo.getLikes());
            stmt.setInt(5, vo.getID());

            System.out.println(vo.getName() + "-" + vo.getArtist() + "-" + vo.getSongAmount() + "-" + vo.getLikes() + "-" + vo.getID());
            stmt.executeUpdate();
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public AlbumVO getMusic(int ID) {
        AlbumVO one = new AlbumVO();
        System.out.println("===> JDBC로 getMusic() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MUSIC_GET);
            stmt.setInt(1, ID);
            rs = stmt.executeQuery();
            if(rs.next()) {
                one.setID(rs.getInt("ID"));
                one.setName(rs.getString("Name"));
                one.setArtist(rs.getString("Artist"));
                one.setSongAmount(rs.getInt("SongAmount"));
                one.setLikes(rs.getInt("Likes"));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return one;
    }

    public List<AlbumVO> getMusicList(){
        List<AlbumVO> list = new ArrayList<AlbumVO>();
        System.out.println("===> JDBC로 getMusicList() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(MUSIC_LIST);
            rs = stmt.executeQuery();
            while(rs.next()) {
                AlbumVO one = new AlbumVO();
                one.setID(rs.getInt("ID"));
                one.setName(rs.getString("Name"));
                one.setArtist(rs.getString("Artist"));
                one.setSongAmount(rs.getInt("SongAmount"));
                one.setLikes(rs.getInt("Likes"));
                list.add(one);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}