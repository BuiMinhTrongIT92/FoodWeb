/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js

function loadDanhGiaMonAn(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let b = document.getElementById("danhgiamonan");
        let h = '';

        for (let d of data) {      
            h += `  
                <div class="mb-4 form-control" style="width: 300px; margin: 10px;">
                    <div>
                        <img src="${d.user.avatar}" alt="Logo" class="rounded-circle" style="width:25px; height: 25px;">
                    </div>
                    <div class=" is-flex is-justify-content-space-between" style="display: flex;">
                        <div class="is-flex is-align-items-center">
                            <span class="name fw-bold">${d.user.tennguoidung}</span>
                        </div>
                            <div class="comment-content">
                                <div id="rating">${d.sao.toString()}</div>
                            </div>
                    </div> 
                    <div class="boxReview-comment-item-review p-2">
                        <div class="item-review-comment my-1 is-flex is-justify-content-space-between is-flex-direction-column">
                            
                            <div class="comment-image is-flex">
                            </div>
                        </div>
                    </div>
                </div>
            `;
        }        
        b.innerHTML = h;
    });
}

function themDanhGiaMonAn(endpoint, idMonAn, xacNhan, thanhCong, thatBai) {
    if (confirm(xacNhan) == true) {
        fetch(endpoint, {
            method: "post",
            body: JSON.stringify({
                "sao": document.getElementById("star-rating").value,
                "idmonan": idMonAn
            }),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function (res) {
            return res.json();
        }).then(function (data) {
            if (data) {
                alert(thanhCong);
                let d = document.getElementById("danhgiamonan");
                
                $(function () {
                    $("#rating").rateYo({
                        rating: 0,
                        readOnly: true
                    });
                });

                let h = `
                    <div class="container boxReview-comment-item mb-4 form-control">
                        <div>
                            <img src="${data.user.avatar}" alt="Logo" class="rounded-circle" style="width:25px; height: 25px;">
                        </div>
                        <div class="boxReview-comment-item-title is-flex is-justify-content-space-between is-align-items-center">
                            <div class="is-flex is-align-items-center">
                                <span class="name fw-bold">${data.user.tennguoidung}</span>
                            </div>
                        </div> 
                        <div class="boxReview-comment-item-review p-2">
                            <div class="item-review-comment my-1 is-flex is-justify-content-space-between is-flex-direction-column">
                                <div class="comment-content">
                                    <div id="rating"></div>
                                </div>
                                <div class="comment-image is-flex">
                                </div>
                            </div>
                        </div>
                    </div>
                    `;
                d.innerHTML = h;
            } else {
                alert(thatBai);
            }
            location.reload();
        });
    }
}

function loadDanhGiaCuaHang(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let b = document.getElementById("danhgiacuahang");
        let h = '';

        for (let d of data) {      
            h += `  
                <div class="mb-4 form-control" style="width: 300px; margin: 10px;">
                    <div>
                        <img src="${d.user.avatar}" alt="Logo" class="rounded-circle" style="width:25px; height: 25px;">
                    </div>
                    <div class=" is-flex is-justify-content-space-between" style="display: flex;">
                        <div class="is-flex is-align-items-center">
                            <span class="name fw-bold">${d.user.tennguoidung}</span>
                        </div>
                            <div class="comment-content">
                                <div id="rating">${d.sao.toString()}</div>
                            </div>
                    </div> 
                    <div class="boxReview-comment-item-review p-2">
                        <div class="item-review-comment my-1 is-flex is-justify-content-space-between is-flex-direction-column">
                            
                            <div class="comment-image is-flex">
                            </div>
                        </div>
                    </div>
                </div>
            `;
        }        
        b.innerHTML = h;
    });
}

function themDanhGiaCuaHang(endpoint, idCuaHang, xacNhan, thanhCong, thatBai) {
    if (confirm(xacNhan) == true) {
        fetch(endpoint, {
            method: "post",
            body: JSON.stringify({
                "sao": document.getElementById("star-rating").value,
                "idcuahang": idCuaHang
            }),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function (res) {
            return res.json();
        }).then(function (data) {
            if (data) {
                alert(thanhCong);
                let d = document.getElementById("danhgiacuahang");
                
                $(function () {
                    $("#rating").rateYo({
                        rating: 0,
                        readOnly: true
                    });
                });

                let h = `
                    <div class="container boxReview-comment-item mb-4 form-control">
                        <div>
                            <img src="${data.user.avatar}" alt="Logo" class="rounded-circle" style="width:25px; height: 25px;">
                        </div>
                        <div class="boxReview-comment-item-title is-flex is-justify-content-space-between is-align-items-center">
                            <div class="is-flex is-align-items-center">
                                <span class="name fw-bold">${data.user.tennguoidung}</span>
                            </div>
                        </div> 
                        <div class="boxReview-comment-item-review p-2">
                            <div class="item-review-comment my-1 is-flex is-justify-content-space-between is-flex-direction-column">
                                <div class="comment-content">
                                    <div id="rating"></div>
                                </div>
                                <div class="comment-image is-flex">
                                </div>
                            </div>
                        </div>
                    </div>
                    `;
                d.innerHTML = h;
            } else {
                alert(thatBai);
            }
            location.reload();
        });
    }
}