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

function layTatCaCuaHangNoiBat(url, btn) {
    getCuahang(url, btn)
}
