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
                                <div class="card card-span h-100 text-white rounded-3" id="iteamcuahang" ><img class="img-fluid rounded-3 h-100" src="${data[i][4]}" alt="..." />
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
        tongtien.innerText = data
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