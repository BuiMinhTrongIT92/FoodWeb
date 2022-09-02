/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bmt.controllers;

/**
 *
 * @author ACER
 */
import com.bmt.pojo.Cuahang;
import com.bmt.pojo.Menuthucan;
import com.bmt.pojo.MenuthucanMonan;
import com.bmt.pojo.Monan;
import com.bmt.pojo.User;
import com.bmt.service.CuaHangService;
import com.bmt.service.MenuService;
import com.bmt.service.MenuThucAnService;
import com.bmt.service.MonAnService;
import com.bmt.service.TheoDoiService;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiMenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private CuaHangService cuaHangService;

    @Autowired
    private MonAnService monAnService;

    @Autowired
    private MenuThucAnService menuThucAnService;

    @Autowired
    private TheoDoiService theoDoiService;

    @Autowired
    MailSender mailSender;

    @GetMapping("/getmenu/{idcuahang}")
    public ResponseEntity<List<Menuthucan>> getMenu(@PathVariable(value = "idcuahang") String idch) {

        List<Menuthucan> menu = this.menuService.getAllMenuByIDCuahang(idch.toString());
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    @GetMapping("/getdetailmenu/{idmenuthucan}")
    public ResponseEntity<List<Menuthucan>> getDetailMenu(@PathVariable(value = "idmenuthucan") int idmenuthucan) {

        List<Menuthucan> menu = new ArrayList<>();
        menu.add(this.menuService.getAllMenuByID(idmenuthucan));
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    @PostMapping("/themmenu")
    public boolean themMenu(@RequestBody Map<String, String> params) {
        try {
            Cuahang ch = this.cuaHangService.getCuaHangByID(params.get("idcuahang"));

            Menuthucan menu = new Menuthucan();
            menu.setActive(true);
            menu.setIdcuahang(ch);
            menu.setTenmenu(params.get("tenmenu"));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
            Date date1 = formatter.parse(params.get("thoidiembatdau"));
            Date date2 = formatter.parse(params.get("thoidiemketthuc"));
            menu.setThoidiembatdau(date1);
            menu.setThoidiemketthuc(date2);
            this.menuService.themMenu(menu);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PutMapping("/suamenu")
    public boolean suaMenu(@RequestBody Map<String, String> params) {
        try {
            Cuahang ch = this.cuaHangService.getCuaHangByID(params.get("idcuahang"));

            Menuthucan menu = new Menuthucan();
            if (params.get("active").contains("true")) {
                menu.setActive(true);
            } else if (params.get("active").contains("false")) {
                menu.setActive(false);
            }
            menu.setIdmenuthucan(Integer.parseInt(params.get("idmenuthucan")));
            menu.setIdcuahang(ch);
            menu.setTenmenu(params.get("tenmenu"));
            if (!params.get("thoidiembatdau").isEmpty() || !params.get("thoidiemketthuc").isEmpty()) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
                Date date1 = formatter.parse(params.get("thoidiembatdau"));
                Date date2 = formatter.parse(params.get("thoidiemketthuc"));
                menu.setThoidiembatdau(date1);
                menu.setThoidiemketthuc(date2);
            } else {
                menu.setThoidiembatdau(null);
                menu.setThoidiemketthuc(null);
            }
            this.menuService.suaMenu(menu);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @DeleteMapping("/xoamenu")
    public boolean xoaMenu(@RequestBody Map<String, String> params) {
        try {
            Menuthucan menu = this.menuService.getAllMenuByID(Integer.parseInt(params.get("idmenuthucan")));
            this.menuService.xoaMenu(menu);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    ADDMonAnVaoMenu
    @GetMapping("/getmenu/monanbych/{idcuahang}")
    public ResponseEntity<List<Monan>> getMonAnByCuahang(@PathVariable(value = "idcuahang") String idcuahang) {

        List<Monan> menu = this.monAnService.getALLMonAnActiveByCuaHang(idcuahang);
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    @GetMapping("/getmonanbymenu/{idmenu}")
    public ResponseEntity<List<MenuthucanMonan>> getMonAnByCuahang(@PathVariable(value = "idmenu") int idmenu) {

        List<MenuthucanMonan> menu = this.menuThucAnService.getMonAnByMenu(idmenu);
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

    @PostMapping("/themmonanvaomenu")
    public boolean themMonAnVaoMenu(@RequestBody Map<String, String> params) {
        try {
            Monan ma = this.monAnService.getMonAnByID(Integer.parseInt(params.get("idmonan")));
            Menuthucan mnta = this.menuService.getAllMenuByID(Integer.parseInt(params.get("idmenu")));
            MenuthucanMonan menuthucanMonan = new MenuthucanMonan();
            if (mnta.getActive() == true) {
                menuthucanMonan.setIdmonan(ma);
                menuthucanMonan.setIdmenuthucan(mnta);
            }
            this.menuThucAnService.themMonAnVaoMenu(menuthucanMonan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @DeleteMapping("/xoamonankhoimenu")
    public boolean xoaMonAnVaoMenu(@RequestBody Map<String, String> params) {
        try {
            MenuthucanMonan menuthucanMonan = this.menuThucAnService.getMenuthucanMonanByID(Integer.parseInt(params.get("idmonanthucan")));

            this.menuThucAnService.xoaMonAnKhoiMenu(menuthucanMonan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostMapping("/guimailmenu")
    public boolean guiMailMenu(@RequestBody Map<String, String> params, HttpSession session) throws MessagingException, UnsupportedEncodingException {
        try {
            String noidung = "Cac mon an moi tai: ";
            if (!params.get("idmenu").isEmpty() && params.get("idmenu") != null) {
                List<MenuthucanMonan> menuitem = this.menuThucAnService.getMonAnByMenu(Integer.parseInt(params.get("idmenu")));
                noidung += this.menuService.getAllMenuByID(Integer.parseInt(params.get("idmenu"))).getTenmenu() + "\n";
                for (MenuthucanMonan k : menuitem) {
                    Monan monan = this.monAnService.getMonAnByID(k.getIdmonan().getIdmonan());
                    noidung += "Ten mon an: " + monan.getTenmonan() + "............Gia" + monan.getGia() + "....Ngay ban" + monan.getThoidiemban() + "\n";
                }
                for (Object h: this.theoDoiService.getAllUserByIDCuaHang(params.get("idcuahang")))
                {
                    this.sendMail("trongbui0983@gmail.com", h.toString(), "Mon an moi", noidung);
                }
//                                    this.sendMail("trongbui0983@gmail.com", "trongbui0927@gmail.com", "Món ăn mới", noidung);

            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void sendMail(String from, String to, String subject, String text) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);

        mailSender.send(mailMessage);
    }
}
