/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function loadBinhLuanMonAn(endpoint) {
    fetch(endpoint).then(function(res) {
        return res.json();
    }).then(function(data) {
        let b = document.getElementById("binhluanmonan");
        let h = '';
        for (let d of data) 
            h += `
        <div class="container boxReview-comment-item mb-4 form-control">
            <div>
                <img src="${d.user.avatar}" alt="Logo" class="rounded-circle" style="width:25px; height: 25px;">
            </div>
            <div class="boxReview-comment-item-title is-flex is-justify-content-space-between is-align-items-center">
                <div class="is-flex is-align-items-center">
                    <span class="name fw-bold">${d.user.tennguoidung}</span>
                </div>
                <p class="date-time"><b>${moment(d.thoigian).locale("vi").fromNow()}</b> - ${moment(d.thoigian).locale("vi").format('lll')}</p>
            </div> 
            <div class="boxReview-comment-item-review p-2">
                <div class="item-review-comment my-1 is-flex is-justify-content-space-between is-flex-direction-column">
                    <div class="comment-content">
                        <p>${d.noidung}</p>
                    </div>
                    <div class="comment-image is-flex">
                    </div>
                </div>
            </div>
        </div>
            `;
        b.innerHTML = h;
    });
}

function themBinhLuanMonAn(endpoint, idMonAn, xacNhan, thanhCong, thatBai) {
    if (confirm(xacNhan) == true) {
        fetch(endpoint, {
            method: "post",
            body: JSON.stringify({
                "noidung" : document.getElementById("noidungBL").value,
                "idmonan" : idMonAn
        }),
            headers: {
                "Content-Type" : "application/json"
            }
        }).then(function (res) {
            return res.json();
        }).then(function (data) {
            if (data) {
                alert(thanhCong);
                let d = document.getElementById("#binhluanmonan");
                let h = `
                    <div class="container boxReview-comment-item mb-4 form-control">
                        <div>
                            <img src="${data.user.avatar}" alt="Logo" class="rounded-circle" style="width:25px; height: 25px;">
                        </div>
                        <div class="boxReview-comment-item-title is-flex is-justify-content-space-between is-align-items-center">
                            <div class="is-flex is-align-items-center">
                                <span class="name fw-bold">${data.user.tennguoidung}</span>
                            </div>
                            <p class="date-time"><b>${moment(data.thoigian).locale("vi").fromNow()}</b> - ${moment(data.thoigian).locale("vi").format('lll')}</p>
                        </div> 
                        <div class="boxReview-comment-item-review p-2">
                            <div class="item-review-comment my-1 is-flex is-justify-content-space-between is-flex-direction-column">
                                <div class="comment-content">
                                    <p>${data.noidung}</p>
                                </div>
                                <div class="comment-image is-flex">
                                </div>
                            </div>
                        </div>
                    </div>
                    `;
                d.insertAdjacentHTML("beforebegin", h); 
            } else {
                alert(thatBai);
            }
            location.reload();
        });
    }   
}

function loadBinhLuanCuaHang(endpoint) {
    fetch(endpoint).then(function(res) {
        return res.json();
    }).then(function(data) {
        let b = document.getElementById("binhluancuahang");
        let h = '';
        for (let d of data) 
            h += `
        <div class="container boxReview-comment-item mb-4 form-control">
            <div>
                <img src="${d.user.avatar}" alt="Logo" class="rounded-circle" style="width:25px; height: 25px;">
            </div>
            <div class="boxReview-comment-item-title is-flex is-justify-content-space-between is-align-items-center">
                <div class="is-flex is-align-items-center">
                    <span class="name fw-bold">${d.user.tennguoidung}</span>
                </div>
                <p class="date-time"><b>${moment(d.thoigian).locale("vi").fromNow()}</b> - ${moment(d.thoigian).locale("vi").format('lll')}</p>
            </div> 
            <div class="boxReview-comment-item-review p-2">
                <div class="item-review-comment my-1 is-flex is-justify-content-space-between is-flex-direction-column">
                    <div class="comment-content">
                        <p>${d.noidung}</p>
                    </div>
                    <div class="comment-image is-flex">
                    </div>
                </div>
            </div>
        </div>
            `;
        b.innerHTML = h;
    });
}

function themBinhLuanCuaHang(endpoint, idCuaHang, xacNhan, thanhCong, thatBai) {
    if (confirm(xacNhan) == true) {
        fetch(endpoint, {
            method: "post",
            body: JSON.stringify({
                "noidung" : document.getElementById("noidungBLCH").value,
                "idcuahang" : idCuaHang
        }),
            headers: {
                "Content-Type" : "application/json"
            }
        }).then(function (res) {
            return res.json();
        }).then(function (data) {
            if (data) {
                alert(thanhCong);
//                let d = document.querySelector("#binhluancuahang li:first-child");
                let d = document.getElementById("#binhluancuahang");
                let h = `
                    <div class="container boxReview-comment-item mb-4 form-control">
                        <div>
                            <img src="${data.user.avatar}" alt="Logo" class="rounded-circle" style="width:25px; height: 25px;">
                        </div>
                        <div class="boxReview-comment-item-title is-flex is-justify-content-space-between is-align-items-center">
                            <div class="is-flex is-align-items-center">
                                <span class="name fw-bold">${data.user.tennguoidung}</span>
                            </div>
                            <p class="date-time"><b>${moment(data.thoigian).locale("vi").fromNow()}</b> - ${moment(data.thoigian).locale("vi").format('lll')}</p>
                        </div> 
                        <div class="boxReview-comment-item-review p-2">
                            <div class="item-review-comment my-1 is-flex is-justify-content-space-between is-flex-direction-column">
                                <div class="comment-content">
                                    <p>${data.noidung}</p>
                                </div>
                                <div class="comment-image is-flex">
                                </div>
                            </div>
                        </div>
                    </div>
                    `;
                d.insertAdjacentHTML("beforebegin", h); 
            } else {
                alert(thatBai);
            }
            location.reload();
        });
    }   
}