/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function getCuahang(endpoint, btn) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let b = document.getElementById("cuahangnoibat");
        if (b !== null) {
            let h = ""
            for (var i = 0; i < data.length; i++) {
                {
                    h += `
                    
                        <div class="col-sm-6 col-md-4 col-lg-3 h-100 mb-5" >
                            <a href = "#">
                                <div class="card card-span h-100 text-white rounded-3" id="iteamcuahang" ><img style="width:280px;height: 200px;" class="img-fluid rounded-3 h-100" src="${data[i][4]}" alt="..." />
                                    <div class="card-img-overlay ps-0"><span class="badge bg-danger p-2 ms-3"><i class="fas fa-tag me-2 fs-0"></i><span class="fs-0">20% off</span></span><span class="badge bg-primary ms-2 me-1 p-2"><i class="fas fa-clock me-1 fs-0"></i><span class="fs-0">Fast</span></span></div>
                                    <div class="card-body ps-0">
                                        <div class="d-flex align-items-center mb-3">
                                            <div class="flex-1 ms-3">
                                                <h5 class="mb-0 fw-bold text-1000">${data[i][1]}</h5><span class="text-primary fs--1 me-1"><i class="fas fa-star"></i></span><span class="mb-0 text-primary">${data[i][5]}</span>
                                            </div>
                                        </div><span class="badge bg-soft-danger p-2"><span class="fw-bold fs-1 text-danger">${btn}</span></span>
                                    </div>
                                </div>
                            </a>
                        </div>
                    `
                }
                b.innerHTML = h
            }
        }

    }).catch(function (erro) {
        console.error(erro)
    })
}


let tib = document.getElementById("tooltips");
let tib2 = document.getElementById("bo");
let tib4 = document.getElementById("bos");

tib.addEventListener("mouseover", () => {
    tib4.style.display = "block";
    fetch("/FoodWeb/api/giohang").then(function (res) {
        return res.json();
    }).then(function (data) {
        kq = ""
        for (var i = 0; i < data.length; i++) {
            kq += `
                    <tr>
                      
                      
                      <td>${data[i]["tenmonan"]}</td>
                      <td>${data[i]["gia"]} VNĐ</td>
                      <td>${data[i]["soluong"]}</td>
                      <td>${data[i]["tongtien"]}</td>
                      <td><img src = "${data[i]["anhmonan"]}" style = "width:50px;height:50px"/></td>
                    </tr>
                `
        }
        tib2.innerHTML = kq
    })

    tib.addEventListener("mouseout", () => {
        tib4.style.display = "none"
    })
})




function getTongTien() {
    fetch("/FoodWeb/api/tongtien").then(function (res) {
        return res.json();
    }).then(function (data) {
        let tongtien = document.getElementById("tongtien");
        var data = data.toLocaleString('it-IT', {style: 'currency', currency: 'VND'});
        tongtien.innerHTML = `<td>${data}</td>`
//        tongtien.innerHTML = `<fmt:formatNumber type="number" value="${data}" maxFractionDigits="3" /> VND`
    }).catch(function (erro) {
        console.error(erro)
    })
}

//function getCuahangs(endpoint) {
//    event.preventDefault();
//    fetch(endpoint).then(function (res) {
//        return res.json();
//    }).then(function (data) {
//        let b = document.getElementById("sss");
//        kq = ""
//        for (var i = 0; i < data.length; i++) {
//            kq += `
//                    <div style="display:flex">
//                        <div>${data[i]["idmonan"]}</div>
//                    <div>${data[i]["tenmonan"]}</div>
//                    <div>${data[i]["gia"]}</div>
//                    <div><img src = "${data[i]["anhmonan"]}" style = "width:50px;height:50px"/></div>
//                    </div>
//                `
//        }
//        b.innerHTML = kq;
//    }).catch(function (erro) {
//        console.error(erro)
//    })
//}





function layTatCaCuaHangNoiBat(url, btn) {
    getCuahang(url, btn)
}

// Get the modal
var modal = document.getElementById("quidinh");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
var btnn = document.getElementById("myBtn");
btnn.onclick = function () {
    modal.style.display = "block";
    modal.style.zIndex = "999999";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function () {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}


//==============GioHang
function themMonAnVaoGio(endpoint, idmonan, tenmonan, gia, anhmonan) {
    event.preventDefault();
    fetch(endpoint, {
        method: 'post',
        body: JSON.stringify({
            "idmonan": idmonan,
            "tenmonan": tenmonan,
            "gia": gia,
            "soluong": 1,
            "anhmonan": anhmonan
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {//dữ liệu từ server trả về
        return res.json()// ép dữ liệu về json
    }).then(function (data) {//trả về kết quả dữ liệu cuối cùng
        let cartsize = document.getElementById("cartsize");
        cartsize.innerText = data
    })
}


function capNhatGio(endpoint, endpointvc, obj, idmonan) {
    event.preventDefault();
    fetch(endpoint, {
        method: 'put',
        body: JSON.stringify({
            "idmonan": idmonan,
            "tenmonan": "",
            "gia": 0,
            "soluong": obj.value,
            "anhmonan": "",

        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {//dữ liệu từ server trả về
        return res.json();// ép dữ liệu về json
    }).then(function (data) {//trả về kết quả dữ liệu cuối cùng
        let cartsize = document.getElementById("cartsize");
        cartsize.innerText = data;
        tienVanChuyen(endpointvc)
        getTongTien();
        hide();
        location.reload();
    })
}



function xoaMonAn(endpoint, endpointvc, idmonan) {
    fetch(endpoint, {
        method: 'delete',
        body: JSON.stringify({
            "idmonan": idmonan,
            "tenmonan": "",
            "gia": 0,
            "soluong": 0,
            "anhmonan": "",
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {//dữ liệu từ server trả về
        return res.json();// ép dữ liệu về json
    }).then(function (data) {//trả về kết quả dữ liệu cuối cùng
        let cartsize = document.getElementById("cartsize");
        cartsize.innerText = data;
        getTongTien();
        tienVanChuyen(endpointvc);
        location.reload();
        hide();
        let hidemonan = document.getElementById(`monanitem${idmonan}`);
        hidemonan.style.display = "none";

    })
}
function hide() {
    let c = document.getElementById("spin");
    c.style.display = "block";
}
function tienVanChuyen(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let b = document.getElementById("tienvanchuyen");
        var data = data.toLocaleString('it-IT', {style: 'currency', currency: 'VND'});
        b.innerText = data;
    }).catch(function (erro) {
        console.error(erro)
    })
}

function thanhToan(endpoint, confim, success, fail) {
    if (confirm(confim) == true) {
        fetch(endpoint, {
            method: 'post'
        }).then(function (res) {//dữ liệu từ server trả về
            return res.json();// ép dữ liệu về json
        }).then(function (code) {//trả về kết quả dữ liệu cuối cùng
            if (code === 'OK') {
                alert(success);
            } else
                alert(fail);
            location.reload();
        });
    }
}
function bat(obj) {
    fetch(`/FoodWeb/api/giohang/${obj.value}`, {
        method: 'get'
    }).then(function (res) {//dữ liệu từ server trả về
        return res.json();// ép dữ liệu về json
    }).then(function (data) {//trả về kết quả dữ liệu cuối cùng
        console.info(data)
        alert(data)
    });
}

function hienDangKyCuahang() {
    let ch = document.getElementById("themcuahang");
    ch.style.display = "block";
}
function anDangKyCuahang() {
    let ch = document.getElementById("themcuahang");
    ch.style.display = "none";
}

function tab(event, formtab) {
    var i, form, tablinks;

    form = document.getElementsByClassName("form");
    for (i = 0; i < form.length; i++) {
        form[i].style.display = "none";
    }

    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    document.getElementById(formtab).style.display = "block";
    event.currentTarget.className += " active";
}
function showcontrol() {
    let cuahang = document.getElementById("cuahanglist");
    cuahang.style.display = "block";
}
function showcontrolmenu() {
    let cuahang = document.getElementById("menulist");
    cuahang.style.display = "block";
}
function showcontroldonhang() {
    let cuahang = document.getElementById("donhanglist");
    cuahang.style.display = "block";
}

function suacuahang(obj) {
    fetch(`/FoodWeb/api/getcuahang/${obj}`, {
        method: 'get'
    }).then(function (res) {//dữ liệu từ server trả về
        return res.json();// ép dữ liệu về json
    }).then(function (data) {//trả về kết quả dữ liệu cuối cùng
        let tencuahang = document.getElementById('tencuahang');
        let vitri = document.getElementById('vitri');
        let active = document.getElementById('status');
        let sua = document.getElementById("sua");
        let xoa = document.getElementById("xoa");
        let logo = document.getElementById("logo");
        sua.setAttribute('onclick', `suaCuahang('${data[0]["idcuahang"]}')`)
        xoa.setAttribute('onclick', `xoaCuahang('${data[0]["idcuahang"]}')`)
//        sua.setAttribute('onclick',"suaCuahang("+data[0]["idcuahang"]+")")
        active.value = data[0]["active"]
        tencuahang.value = data[0]["tencuahang"]
        vitri.value = data[0]["diachi"]
        logo.value = data[0]["logo"]
    });
}

function suaCuahang(idcuahang) {
    let tencuahang = document.getElementById("tencuahang");
    let diachi = document.getElementById("vitri");
    let active = document.getElementById("status");
    let getlogo = document.getElementById("logo");
    let logo = getlogo.value;
    if (l != undefined) {
        logo = l;
    }

    fetch("/FoodWeb/api/capnhatcuahang", {
        method: 'put',
        body: JSON.stringify({
            "idcuahang": idcuahang,
            "tencuahang": tencuahang.value,
            "diachi": diachi.value,
            "active": active.value,
            "logo": logo
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {//dữ liệu từ server trả về
        return res.json();// ép dữ liệu về json
    }).then(function (data) {//trả về kết quả dữ liệu cuối cùng
        location.reload();
        if (data == true) {
            alert('Thành công')
        } else
            alert('Thất bại')

    });
}

function xoaCuahang(idcuahang) {

    fetch("/FoodWeb/api/capnhatcuahang", {
        method: 'put',
        body: JSON.stringify({
            "idcuahang": idcuahang,
            "tencuahang": "",
            "diachi": "",
            "active": false,
            "logo": logo
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {//dữ liệu từ server trả về
        return res.json();// ép dữ liệu về json
    }).then(function (data) {//trả về kết quả dữ liệu cuối cùng
        location.reload();
        if (data == true) {
            alert('Thành công')
        } else
            alert('Thất bại')

    });
}

var l = ''

function luu() {
    let tencuahang = document.getElementById('tencuahang');
    let vitri = document.getElementById('vitri');
    let active = document.getElementById('status');
    var logo = '';
    if (l == undefined) {
        logo = 'https://res.cloudinary.com/trongbui/image/upload/v1658997161/cld-sample-2.jpg';
    } else
        logo = l;
    fetch("/FoodWeb/api/quanlycuahang", {
        method: 'post',
        body: JSON.stringify({
            "tencuahang": tencuahang.value,
            "diachi": vitri.value,
            "active": active.value,
            "logo": logo,
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {//dữ liệu từ server trả về
        return res.json();// ép dữ liệu về json
    }).then(function (data) {//trả về kết quả dữ liệu cuối cùng
        l = '';
        location.reload();
        if (data == true) {
            alert('Thành công')
        } else
            alert('Thất bại')

    });
}

//=============Món Ăn API
function getmonandetail(idmonan) {
    fetch(`/FoodWeb/api/getmonan/${idmonan}`, {
        method: 'get'
    }).then(function (res) {//dữ liệu từ server trả về
        return res.json();// ép dữ liệu về json
    }).then(function (data) {//trả về kết quả dữ liệu cuối cùng
        let tenmonan = document.getElementById('tenmonan');
        let gia = document.getElementById('gia');
        let soluong = document.getElementById('soluong');
        let thoidiemban = document.getElementById("thoidiemban");
        let thoidiemketthuc = document.getElementById("thoidiemketthuc");
        let trangthai = document.getElementById("trangthai");
        let active = document.getElementById("active");
        let anhmonan = document.getElementById("anhmonan");
        let suamonan = document.getElementById("suamonan");
        suamonan.setAttribute('onclick', `suaMonan(${data[0]["idmonan"]})`)
        tenmonan.value = data[0]["tenmonan"];
        gia.value = data[0]["gia"];
        soluong.value = data[0]["soluong"];
        thoidiemban.value = formatDay(data[0]["thoidiemban"]);
        thoidiemketthuc.value = formatDay(data[0]["thoidiemketthuc"]);
        trangthai.value = data[0]["trangthai"];
        active.value = data[0]["active"];
        anhmonan.value = data[0]["anhmonan"];

    });
}

var anhmon = ''
function themmonan() {
    let tenmonan = document.getElementById('tenmonan');
    let gia = document.getElementById('gia');
    let soluong = document.getElementById('soluong');
    let thoidiemban = document.getElementById("thoidiemban");
    let thoidiemketthuc = document.getElementById("thoidiemketthuc");
    let trangthai = document.getElementById("trangthai");
    let active = document.getElementById("active");
    if (anhmon == undefined) {
        logo = 'https://res.cloudinary.com/trongbui/image/upload/v1658997161/cld-sample-2.jpg';
    } else
        logo = anhmon;
    fetch("/FoodWeb/api/themmonan", {
        method: 'post',
        body: JSON.stringify({
            "tenmonan": tenmonan.value,
            "gia": gia.value,
            "soluong": soluong.value,
            "thoidiemban": new Date(moment(thoidiemban.value).format('YYYY-MM-DD HH:mm:ss')),
            "thoidiemketthuc": new Date(moment(thoidiemketthuc.value).format('YYYY-MM-DD HH:mm:ss')),
            "trangthai": trangthai.value,
            "active": active.value,
            "anhmonan": logo
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {//dữ liệu từ server trả về
        return res.json();// ép dữ liệu về json
    }).then(function (data) {//trả về kết quả dữ liệu cuối cùng
        anhmon = '';
        location.reload();
        if (data == true) {
            alert('Thành công')
        } else
            alert('Thất bại')

    });
}


function suaMonan(idmonan) {
    let tenmonan = document.getElementById('tenmonan');
    let gia = document.getElementById('gia');
    let soluong = document.getElementById('soluong');
    let thoidiemban = document.getElementById("thoidiemban");
    let thoidiemketthuc = document.getElementById("thoidiemketthuc");
    let trangthai = document.getElementById("trangthai");
    let active = document.getElementById("active");
    let anhmonan = document.getElementById("anhmonan");
    if (anhmon == undefined) {
        logo = anhmonan.value;
    } else
        logo = anhmon;
    fetch("/FoodWeb/api/suamonan", {
        method: 'put',
        body: JSON.stringify({
            "idmonan": idmonan,
            "tenmonan": tenmonan.value,
            "gia": gia.value,
            "soluong": soluong.value,
            "thoidiemban": new Date(moment(thoidiemban.value).format('YYYY-MM-DD HH:mm:ss')),
            "thoidiemketthuc": new Date(moment(thoidiemketthuc.value).format('YYYY-MM-DD HH:mm:ss')),
            "trangthai": trangthai.value,
            "active": active.value,
            "anhmonan": logo
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {//dữ liệu từ server trả về
        return res.json();// ép dữ liệu về json
    }).then(function (data) {//trả về kết quả dữ liệu cuối cùng
        anhmon = '';
        location.reload();
        if (data == true) {
            alert('Thành công')
        } else
            alert('Thất bại')

    });
}


function formatDay(ngay) {
    let s = ngay;
    let c = new Date(s).toLocaleTimeString();
    let f = moment(s).format('YYYY-MM-DD');
    return kq = f + "T" + c.substring(0, c.lastIndexOf(":"));
}


//================MENU
function getmenu() {
    let id = document.getElementById("choncuahang").value;
    fetch(`/FoodWeb/api/getmenu/${id}`, {
        method: 'get',
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let b = document.getElementById("menuthuca");
        if (b !== null) {
            let h = "";
            for (var i = 0; i < data.length; i++) {
                {
                    let ngaybd = moment(data[i]["thoidiembatdau"]).format('YYYY-MM-DD HH:mm:ss')
                    let ngaykt = moment(data[i]["thoidiemketthuc"]).format('YYYY-MM-DD HH:mm:ss')
                    h += `
                    
                        <tr class="themcuahangitem" id="menuclick" onclick="getmenudetail(${data[i]["idmenuthucan"]})">
                            <td>${data[i]["idmenuthucan"]}</td>
                            <td>${data[i]["active"]}</td>
                            <td>${data[i]["idcuahang"]["idcuahang"]}</td>
                            <td>${ngaybd}</td>
                            <td>${ngaykt}</td>
                            <td><a type="button" class = "btn btn-danger" onclick="xoaMenu(${data[i]["idmenuthucan"]})"><i class="fas fa-trash"></i></a></td>
                        </tr>

                    `
                }
                b.innerHTML = h;
            }
        }

    });
}


function getmenudetail(idmenuthucan) {
    fetch(`/FoodWeb/api/getdetailmenu/${idmenuthucan}`, {
        method: 'get'
    }).then(function (res) {//dữ liệu từ server trả về
        return res.json();// ép dữ liệu về json
    }).then(function (data) {//trả về kết quả dữ liệu cuối cùng
        let choncuahang = document.getElementById('choncuahang');
        let activemenu = document.getElementById('activemenu');
        let thoidiembanmenu = document.getElementById('thoidiembanmenu');
        let thoidiemketthucmenu = document.getElementById("thoidiemketthucmenu");
        let suamenu = document.getElementById("suamenu");
        suamenu.setAttribute('onclick', `suaMenu(${idmenuthucan})`)
        choncuahang.choncuahang = data[0]["idcuahang"];
        activemenu.value = data[0]["active"];
        thoidiembanmenu.value = formatDay(data[0]["thoidiembatdau"]);
        thoidiemketthucmenu.value = formatDay(data[0]["thoidiemketthuc"]);
    });
}


function themmenu() {
    let thoidiembanmenu = document.getElementById('thoidiembanmenu');
    let thoidiemketthucmenu = document.getElementById("thoidiemketthucmenu");
    fetch("/FoodWeb/api/themmenu", {
        method: 'post',
        body: JSON.stringify({
            "active": document.getElementById('activemenu').value,
            "thoidiembatdau": moment(thoidiembanmenu.value).format('YYYY-MM-DD HH:mm:ss'),
            "thoidiemketthuc": moment(thoidiemketthucmenu.value).format('YYYY-MM-DD HH:mm:ss'),
            "idcuahang": document.getElementById("choncuahang").value,
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {//dữ liệu từ server trả về
        return res.json();// ép dữ liệu về json
    }).then(function (data) {//trả về kết quả dữ liệu cuối cùng
        location.reload();
        if (data == true) {
            alert('Thành công')
        } else
            alert('Thất bại')

    });
}

function suaMenu(idmenu) {
    let thoidiembanmenu = document.getElementById('thoidiembanmenu');
    let thoidiemketthucmenu = document.getElementById("thoidiemketthucmenu");
    fetch("/FoodWeb/api/suamenu", {
        method: 'put',
        body: JSON.stringify({
            "idmenuthucan": idmenu,
            "active": document.getElementById('activemenu').value,
            "thoidiembatdau": moment(thoidiembanmenu.value).format('YYYY-MM-DD HH:mm:ss'),
            "thoidiemketthuc": moment(thoidiemketthucmenu.value).format('YYYY-MM-DD HH:mm:ss'),
            "idcuahang": document.getElementById("choncuahang").value,
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {//dữ liệu từ server trả về
        return res.json();// ép dữ liệu về json
    }).then(function (data) {//trả về kết quả dữ liệu cuối cùng
        location.reload();
        if (data == true) {
            alert('Thành công')
        } else
            alert('Thất bại')

    });
}

function xoaMenu(idmenu) {
    fetch("/FoodWeb/api/xoamenu", {
        method: 'delete',
        body: JSON.stringify({
            "idmenuthucan": idmenu,
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {//dữ liệu từ server trả về
        return res.json();// ép dữ liệu về json
    }).then(function (data) {//trả về kết quả dữ liệu cuối cùng
        location.reload();
        if (data == true) {
            alert('Thành công')
        } else
            alert('Thất bại')
    });
}
//================MENUDETAIL
function getMenuByIDCuahang() {
    let id = document.getElementById("dscuahang").value;
    fetch(`/FoodWeb/api/getmenu/${id}`, {
        method: 'get',
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let b = document.getElementById("dsmenu");
        if (b !== null) {
            let h = "";
            for (var i = 0; i < data.length; i++) {
                {
                    h += `
                            <option value="${data[i]["idmenuthucan"]}">${data[i]["idmenuthucan"]}</option>
                    `
                }
                b.innerHTML = h;
            }
        }
        getMonAnByMenu(id);

    });
}

function getMonAnByMenu(idcuahang) {
    fetch(`/FoodWeb/api/getmenu/monanbych/${idcuahang}`, {
        method: 'get',
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let b = document.getElementById("dsmonanbycuahang");
        if (b !== null) {
            let h = "";
            if (data.length > 0) {
                for (var i = 0; i < data.length; i++) {

                    {
                        h += `
                            <option value="${data[i]["idmonan"]}">${data[i]["tenmonan"]}</option>
                    `
                    }
                }
            } else {
                h += `
                            <option></option>
                    `
            }
            b.innerHTML = h;
        }

    });

}

function getMenuThucAnMonAnByMenu() {
    let idmenu = document.getElementById("dsmenu").value;
    fetch(`/FoodWeb/api/getmonanbymenu/${idmenu}`, {
        method: 'get',
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let b = document.getElementById("menuthucanmonan");
        if (b !== null) {
            let h = "";
            if (data.length > 0) {
                for (var i = 0; i < data.length; i++) {
                    {
                        h += `
                        <tr>
                            <td>${data[i]["idmenuthucan"]["idmenuthucan"]}</td>
                            <td>${data[i]["idmonan"]["tenmonan"]}</td>
                            <td><a type="button" class = "btn btn-danger" onclick="xoaMonAnKhoiMenu(${data[i]["idmenuthucanmonan"]})"><i class="fas fa-trash"></i></a></td>
                        </tr>
                    `
                    }

                }
            } else {
                h += `
                        <tr>
                        </tr>
                    `
            }
            b.innerHTML = h;
        }

    });
}

function themmonvaomenu() {
    let idmenu = document.getElementById("dsmenu").value;
    let idmonan = document.getElementById("dsmonanbycuahang").value;
    fetch(`/FoodWeb/api/themmonanvaomenu`, {
        method: 'post',
        body: JSON.stringify({
            "idmenu": idmenu,
            "idmonan": idmonan
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        location.reload();
        if (data == true) {
            alert('Thành công');
        } else
            alert('Thất bại');
    });
}


function xoaMonAnKhoiMenu(idmonanthucan) {
    fetch(`/FoodWeb/api/xoamonankhoimenu`, {
        method: 'delete',
        body: JSON.stringify({
            "idmonanthucan": idmonanthucan,
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        location.reload();
        if (data == true) {
            alert('Thành công');
        } else
            alert('Thất bại');
    });
}

//==================DONHANG
function getDonHang(endpoint) {
    fetch(endpoint, {
        method: 'post',
        body: JSON.stringify({
            "idcuahang": document.getElementById("donhangcuahang").value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let b = document.getElementById("donhang");
        if (b !== null) {
            let h = "";
            if (data.length > 0) {
                for (var i = 0; i < data.length; i++) {
                    {

                        let date = formatDay(data[i]["ngaytao"]);
                        h += `
                        
                        <tr onclick="getDetailDonHang('${data[i]["iddonhang"]}')">
                            <td scope="col">${data[i]["iddonhang"]}</td>
                            <td scope="col">${date}</td>
                            <td scope="col">${data[i]["khuyenmai"]}</td>
                            <td scope="col">
                            
                            <select class="form-control form__input suatrangthaidonhang" id="trangthaidon${i.toString()}" onchange="suaDonhang('${data[i]["iddonhang"]}',this)">
                                    <option value="choduyet">Chờ duyệt</option>
                                    <option value="daxacnhan">Đã xác nhận</option>
                                    <option value="huy">Hủy</option>
                                    <option value="dangvanchuyen">Đang vận chuyển</option>
                                    <option value="thanhcong">Thành công</option>
                            </select></td>
                            <td scope="col">${data[i]["tongtien"]}</td>
                        </tr>
                        `
                        b.innerHTML = h;

                    }
                }
                for (var i = 0; i < data.length; i++) {
                    {
                        let sta = document.getElementById(`trangthaidon${i}`);
                        sta.value = data[i]["trangthai"]
                    }
                }
            } else {
                h += `<tr>
                        </tr>
                    `
                b.innerHTML = h
            }
        }

    })
}
function getDetailDonHang(iddonhang) {
    fetch(`/FoodWeb/api/donhang/chitietdonhang`, {
        method: 'post',
        body: JSON.stringify({
            "iddonhang": iddonhang,
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let b = document.getElementById("chitietdonhang");
        if (b !== null) {
            let h = "";
            if (data.length > 0) {
                for (var i = 0; i < data.length; i++) {
                    {
                        h += `
                        <tr>
                            <td scope="col">${data[i]["iddonhangmonan"]}</td>
                            <td scope="col">${data[i]["iddonhang"]["iddonhang"]}</td>
                            <td scope="col">${data[i]["idmonan"]["idmonan"]}</td>
                            <td scope="col">${data[i]["soluong"]}</td>
                            <td scope="col">${data[i]["gia"]}</td>
                            <td scope="col">${data[i]["tongtien"]}</td>
                        </tr>
                        `
                        b.innerHTML = h;

                    }
                }
            }
        }

    })
}

function suaDonhang(iddonhang,obj) {
    fetch("/FoodWeb/api/donhang/suadonhang", {
        method: 'post',
        body: JSON.stringify({
            "iddonhang": iddonhang,
            "trangthai": obj.value,
           
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {//dữ liệu từ server trả về
        return res.json();// ép dữ liệu về json
    }).then(function (data) {//trả về kết quả dữ liệu cuối cùng
        location.reload();
        if (data == true) {
            alert('Thành công')
        } else
            alert('Thất bại')

    });
}
