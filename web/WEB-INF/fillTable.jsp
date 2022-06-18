<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/31
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="fillTable" class="row" style="margin-top: 20px">
    <div class="col-md-12">
        <form action="HealthCode" method="post" onsubmit="return isOK()">
            <div class="form-row">
                <div class="col-md-12">
                    <h3>个人基本信息</h3>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <div class="col-sm-4"><label class="col-form-label"
                                                     style="font-family:Lato, sans-serif;font-weight:normal;"
                                                     for="nombre">姓名</label></div>
                        <div class="col-sm-8"><input class="form-control none-input" type="text"
                                                     name="nombre" value="<%=lid.getName() %>">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4"><label class="col-form-label"
                                                     style="font-family:Lato, sans-serif;font-weight:normal;"
                                                     for="titular">身份证号</label></div>
                        <div class="col-sm-8"><input class="form-control none-input" type="text"
                                                     name="titular" value="<%=lid.getId() %>">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4"><label class="col-form-label"
                                                     style="font-family:Lato, sans-serif;font-weight:normal;"
                                                     for="nombre">学号/工号</label></div>
                        <div class="col-sm-8"><input class="form-control none-input" type="text"
                                                     name="nombre" value="<%=lid.getNumber() %>">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4"><label class="col-form-label"
                                                     style="font-family:Lato, sans-serif;font-weight:normal;"
                                                     for="titular">手机号</label></div>
                        <div class="col-sm-8"><input class="form-control" type="text"
                                                     name="phone" id="phonefill">
                        </div>
                    </div>
                </div>
            </div>

            <hr>
            <div class="form-row">
                <div class="col-md-12">
                    <h3>近期活动情况</h3>
                </div>
                <div class="col-md-5">
                    <p>您的行踪将直接关系到健康码状态</p>
                </div>
                <div class="col-md-7">
                    <div class="form-group">
                        <div class="col-sm-8"><label class="col-form-label"
                                                     for="direccion">本人近期（14天内）是否去过重点疫区？
                        </label></div>
                        <div class="col-sm-8"><select class="form-control" name="EpidemicArea">
                            <optgroup>
                                <option value="No" selected="">否</option>
                                <option value="Yes">是</option>
                            </optgroup>
                        </select></div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-8"><label class="col-form-label" for="cp">本人近期（14天内）是否去过国外？
                            </label></div>
                        <div class="col-sm-8"><select class="form-control" name="Abroad">
                            <optgroup>
                                <option value="No" selected="">否</option>
                                <option value="Yes">是</option>
                            </optgroup>
                        </select></div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-8"><label class="col-form-label"
                                                     for="municipio">本人近期（14天内）是否接触过新冠确诊病人或疑似病人？
                        </label></div>
                        <div class="col-sm-8"><select class="form-control" name="Patient">
                            <optgroup>
                                <option value="No" selected="">否</option>
                                <option value="Yes">是</option>
                            </optgroup>
                        </select></div>
                    </div>
                </div>
            </div>
            <hr>
            <div class="form-row">
                <div class="col-md-12">
                    <h3>个人健康状况</h3>
                </div>
                <div class="col-md-5">
                    <p>如实填写健康情况以获得正确的健康码</p>
                </div>
                <div class="col-md-7">
                    <div class="form-group">
                        <div class="col-sm-8"><label class="col-form-label"
                                                     for="direccion">本人是否被卫生部门确认为新冠肺炎确诊病例或疑似病例？
                        </label></div>
                        <div class="col-sm-8"><select class="form-control" name="ill">
                            <optgroup>
                                <option value="No" selected="">否</option>
                                <option value="Yes">是</option>
                            </optgroup>
                        </select></div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-8"><label class="col-form-label"
                                                     for="municipio">当前健康状况？有无异常、发烧（≥37.3℃）、乏力、干咳、鼻塞、流涕、咽痛、腹泻等？
                        </label></div>
                        <div class="col-sm-8"><select class="form-control" name="healthy">
                            <optgroup>
                                <option value="No" selected="">身体健康，无异常</option>
                                <option value="Yes1">有上述一种症状</option>
                                <option value="Yes2">有上述两种症状及以上</option>
                            </optgroup>
                        </select></div>
                    </div>
                </div>
            </div>
            <div class="form-row">
                <div class="col-md-12">
                    <h3>疫苗注射状况</h3>
                </div>
                <div class="col-md-5">
                    <p>如实填写疫苗注射情况</p>
                </div>
                <div class="col-md-7">
                    <div class="form-group">
                        <div class="col-sm-8"><label class="col-form-label"
                                                     for="direccion">本人是否已接种疫苗？
                        </label></div>
                        <div class="col-sm-8"><select class="form-control" name="inject">
                            <optgroup>
                                <option value="No" selected="">否</option>
                                <option value="Yes">是</option>
                            </optgroup>
                        </select></div>
                    </div>
                </div>
            </div>
            <hr>
            <div class="form-row">
                <div class="col-md-12">
                    <h3></h3>
                </div>
                <div class="col-md-5">
                    <p style="line-height:20px;font-weight:normal;font-family:Lato, sans-serif;"></p>
                </div>
                <div class="col-md-7">
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="form-check" style="margin-bottom:0px;"><input
                                    class="form-check-input" type="checkbox" name="12h" id="formCheck-5"
                                    checked="checked"><label class="form-check-label"
                                                             for="formCheck-5">本人郑重承诺：填报信息真实，愿意承担相应的法律责任。</label></div>
                        </div>
                        <script>
                            function isOK()
                            {
                                var condition1 = document.getElementById('formCheck-5');
                                var condition2 = document.getElementById('phonefill');
                                if(condition1.checked == true&&condition2.value != "")
                                {
                                    return true;
                                }
                                else
                                {
                                    alert("手机号为空或未勾选承诺！");
                                    return false;
                                }
                            }
                        </script>
                        <div class="col-sm-8">
                            <input class="submit-button" type="submit">
                        </div>
                    </div>
                </div>
            </div>
            <hr>
        </form>
    </div>
</div>
