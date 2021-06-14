<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


		<div class="row">
            <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
                <form action="/selectDong" method="post">
                    <div class="form-row" style="height:100px;">
                        <div class="col-12 col-md-9 my-auto">
                            <div class="form-group my-auto">
                                <label for="sel1">주소 :</label>
                                <select name="city" class="form-control-inline selectpicker" style="width:120px;" id="city" onchange="javascript:searchGugun(this);">
                                	<option>선택</option>
                                </select>
                                <select name = "gugun" class="form-control-inline" style="width:120px;" id="gugun" onchange="javascript:searchDong(this);">
                                	<option>선택</option>
                                </select>
                                <select name = "dong" class="form-control-inline" style="width:120px;" id="dong">
                                	<option>선택</option>
                                </select>

                            </div>
                        </div>
                        <div class="col-12 col-md-2 my-auto">
                        	<input type="submit" value="Search!" class="btn btn-block btn-lg btn-primary">
                        </div>
                    </div>
                    
                </form>
            </div>
        </div>
