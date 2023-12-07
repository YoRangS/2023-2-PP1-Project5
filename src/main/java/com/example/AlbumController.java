package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumService albumServcice;

    @RequestMapping(value="/")
    public String index() {
        return "posts";
    }

    @RequestMapping(value="/posts", method = RequestMethod.GET)
    public String albumlist(Model model){
        model.addAttribute("posts", albumServcice.getAlbumList());
        return "posts";
    }

    @RequestMapping(value="/view/ID={id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") int id, Model model){
        AlbumVO albumVO = albumServcice.getAlbum(id);
        model.addAttribute("post", albumVO);
        return "view";
    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String add() {
        return "addform";
    }

    @RequestMapping(value="/addok", method = RequestMethod.POST)
    public String addPostOK(AlbumVO vo) {
        if(albumServcice.insertAlbum(vo) == 0)
            System.out.println("앨범 추가 실패");
        else
            System.out.println("앨범 추가 성공!");
        return "redirect:posts";
    }

    @RequestMapping(value="/editform/ID={id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id, Model model) {
        AlbumVO albumVO = albumServcice.getAlbum(id);
        model.addAttribute("post", albumVO);
        return "editform";
    }

    @RequestMapping(value="/editok", method = RequestMethod.POST)
    public String editOk(AlbumVO vo) {
        if(albumServcice.updateAlbum(vo) == 0)
            System.out.println("앨범 수정 실패");
        else
            System.out.println("앨범 수정 성공!");
        return "redirect:posts";
    }

    @RequestMapping(value="/deleteok/{id}", method = RequestMethod.GET)
    public String deletePostOk(@PathVariable("id") int id) {
        if(albumServcice.deleteAlbum(id) == 0)
            System.out.println("앨범 삭제 실패");
        else
            System.out.println("앨범 삭제 성공!");
        return "redirect:../posts";
    }
}