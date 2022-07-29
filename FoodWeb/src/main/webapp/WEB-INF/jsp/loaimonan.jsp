<%-- 
    Document   : loaimonan
    Created on : Jul 29, 2022, 8:23:51 AM
    Author     : NhatTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="py-4 overflow-hidden" style="margin-top: 40px;">
    <div class="container">
        <div class="row h-100">
            <div class="col-12">
                <div class="carousel slide" id="carouselPopularItems" data-bs-touch="false" data-bs-interval="false">
                    <div class="carousel-inner">
                        <div class="carousel-item active" data-bs-interval="10000">
                            <div class="row gx-3 h-100 align-items-center">
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                    <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/gallery/burger.png" alt="..."/>
                                        <div class="card-body ps-0">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                        </div>
                                    </div>
                                    <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button">Order now</a></div>
                                </div>
                                
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                    <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/gallery/burger.png" alt="..."/>
                                        <div class="card-body ps-0">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">Dancake</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Cake World</span></div><span class="text-1000 fw-bold">$1.99</span>
                                        </div>
                                    </div>
                                    <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button">Order now</a></div>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                    <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/gallery/burger.png" alt="..."/>
                                        <div class="card-body ps-0">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">Crispy Sandwitch</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Fastfood Dine</span></div><span class="text-1000 fw-bold">$3.00</span>
                                        </div>
                                    </div>
                                    <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button">Order now</a></div>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                    <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="resources/img/gallery/burger.png" alt="..."/>
                                        <div class="card-body ps-0">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">Thai Soup</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Foody Man</span></div><span class="text-1000 fw-bold">$2.79</span>
                                        </div>
                                    </div>
                                    <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button">Order now</a></div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item" data-bs-interval="5000">
                            <div class="row gx-3 h-100 align-items-center">
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                    <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="<c:url value="/img/gallery/discount-item-4.png"/>" alt="..." />
                                        <div class="card-body ps-0">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                        </div>
                                    </div>
                                    <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button">Order now</a></div>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                    <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="<c:url value="/img/gallery/discount-item-4.png"/>" alt="..." />
                                        <div class="card-body ps-0">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">Toffe's Cake</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Top Sticks</span></div><span class="text-1000 fw-bold">$4.00</span>
                                        </div>
                                    </div>
                                    <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button">Order now</a></div>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                    <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="<c:url value="/img/gallery/discount-item-4.png"/>" alt="..." />
                                        <div class="card-body ps-0">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">Dancake</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Cake World</span></div><span class="text-1000 fw-bold">$1.99</span>
                                        </div>
                                    </div>
                                    <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button">Order now</a></div>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                    <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="<c:url value="/img/gallery/discount-item-4.png"/>" alt="..." />
                                        <div class="card-body ps-0">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">Crispy Sandwitch</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Fastfood Dine</span></div><span class="text-1000 fw-bold">$3.00</span>
                                        </div>
                                    </div>
                                    <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button">Order now</a></div>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                    <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="<c:url value="/img/gallery/discount-item-4.png"/>" alt="..." />
                                        <div class="card-body ps-0">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">Thai Soup</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Foody Man</span></div><span class="text-1000 fw-bold">$2.79</span>
                                        </div>
                                    </div>
                                    <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button">Order now</a></div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item" data-bs-interval="3000">
                            <div class="row gx-3 h-100 align-items-center">
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                    <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="<c:url value="/img/gallery/discount-item-4.png"/>" alt="..." />
                                        <div class="card-body ps-0">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                        </div>
                                    </div>
                                    <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button">Order now</a></div>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                    <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="<c:url value="/img/gallery/discount-item-4.png"/>" alt="..." />
                                        <div class="card-body ps-0">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">Toffe's Cake</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Top Sticks</span></div><span class="text-1000 fw-bold">$4.00</span>
                                        </div>
                                    </div>
                                    <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button">Order now</a></div>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                    <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="<c:url value="/img/gallery/discount-item-4.png"/>" alt="..." />
                                        <div class="card-body ps-0">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">Dancake</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Cake World</span></div><span class="text-1000 fw-bold">$1.99</span>
                                        </div>
                                    </div>
                                    <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button">Order now</a></div>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                    <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="<c:url value="/img/gallery/discount-item-4.png"/>" alt="..." />
                                        <div class="card-body ps-0">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">Crispy Sandwitch</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Fastfood Dine</span></div><span class="text-1000 fw-bold">$3.00</span>
                                        </div>
                                    </div>
                                    <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button">Order now</a></div>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                    <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="<c:url value="/img/gallery/discount-item-4.png"/>" alt="..." />
                                        <div class="card-body ps-0">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">Thai Soup</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Foody Man</span></div><span class="text-1000 fw-bold">$2.79</span>
                                        </div>
                                    </div>
                                    <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button">Order now</a></div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="row gx-3 h-100 align-items-center">
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                    <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="<c:url value="/img/gallery/discount-item-4.png"/>" alt="..." />
                                        <div class="card-body ps-0">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">Cheese Burger</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Burger Arena</span></div><span class="text-1000 fw-bold">$3.88</span>
                                        </div>
                                    </div>
                                    <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button">Order now</a></div>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                    <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="<c:url value="/img/gallery/discount-item-4.png"/>" alt="..." />
                                        <div class="card-body ps-0">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">Toffe's Cake</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Top Sticks</span></div><span class="text-1000 fw-bold">$4.00</span>
                                        </div>
                                    </div>
                                    <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button">Order now</a></div>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                    <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="<c:url value="/img/gallery/discount-item-4.png"/>" alt="..." />
                                        <div class="card-body ps-0">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">Dancake</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Cake World</span></div><span class="text-1000 fw-bold">$1.99</span>
                                        </div>
                                    </div>
                                    <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button">Order now</a></div>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                    <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="<c:url value="/img/gallery/discount-item-4.png"/>" alt="..." />
                                        <div class="card-body ps-0">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">Crispy Sandwitch</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Fastfood Dine</span></div><span class="text-1000 fw-bold">$3.00</span>
                                        </div>
                                    </div>
                                    <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button">Order now</a></div>
                                </div>
                                <div class="col-sm-6 col-md-4 col-xl mb-5 h-100">
                                    <div class="card card-span h-100 rounded-3"><img class="img-fluid rounded-3 h-100" src="<c:url value="/img/gallery/discount-item-4.png"/>" alt="..." />
                                        <div class="card-body ps-0">
                                            <h5 class="fw-bold text-1000 text-truncate mb-1">Thai Soup</h5>
                                            <div><span class="text-warning me-2"><i class="fas fa-map-marker-alt"></i></span><span class="text-primary">Foody Man</span></div><span class="text-1000 fw-bold">$2.79</span>
                                        </div>
                                    </div>
                                    <div class="d-grid gap-2"><a class="btn btn-lg btn-danger" href="#!" role="button">Order now</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button class="carousel-control-prev carousel-icon" type="button" data-bs-target="#carouselPopularItems" data-bs-slide="prev"><span class="carousel-control-prev-icon hover-top-shadow" aria-hidden="true"></span><span class="visually-hidden">Previous</span></button>
                    <button class="carousel-control-next carousel-icon" type="button" data-bs-target="#carouselPopularItems" data-bs-slide="next"><span class="carousel-control-next-icon hover-top-shadow" aria-hidden="true"></span><span class="visually-hidden">Next </span></button>
                </div>
            </div>
        </div>
    </div><!-- end of .container-->
</section>
