/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


//LẤY PHIẾU ĐẶT (KHÁCH HÀNG)
function getAppointment(endpoint) {
    fetch(endpoint).then(function (res) {
        return  res.json();
    }).then(function (data) {
        let d = document.getElementById("myAppointment");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                    <tr id="row${data[i][0]}">
                        <td></td>
                        <td>${data[i][0]}</td>
                        <td>${moment(data[i][1]).format("DD/MM/YYYY")}</td>
                        <td>${data[i][2]}</td>
                        <td>${data[i][3]}</td>
                        <td>${data[i][8]}</td>
                        <td>
                            <div class="spinner-border text-warning" style="display:none" id="load${data[i][0]}"></div>
                            <i onclick="deleteAppointment('${endpoint + "/" + data[i][0]}', ${data[i][0]}, this)" class="fas fa-trash-alt"></i>
                        </td>
                    </tr>
                    `;
            d.innerHTML = h;
        }

    }).catch(function (err) {
        console.error(err);
    });
}


// XOÁ PHIẾU ĐẶT (khách hàng)
function deleteAppointment(endpoint, id, btn) {
    fetch('/Web_QuanLyPhongMach/api/appointment').then(function (res) {
        return  res.json();
    }).then(function (data) {
        a = true;
        for (let i = 0; i < data.length; i++)
            if (data[i][7] === 2 && data[i][0] === id)
            {
                alert("Lịch khám đã được xác nhận! Không thể huỷ!");
                a = false;
            }
        if (a) {
            if (confirm("Bạn có chắc chắn xoá?") === true) {
                let r = document.getElementById(`row${id}`);
                let load = document.getElementById(`load${id}`);
                load.style.display = "block";
                btn.style.display = "none";
                fetch(endpoint, {
                    method: 'delete'
                }).then(function (res) {
                    if (res.status !== 204)
                        load.style.display = "none";
                    r.style.display = "none";
                }).catch(function (err) {
                    console.error(err);
                    btn.style.display = "block";
                    load.style.display = "none";
                });
            }
        }
    });
}



//LẤY PHIẾU ĐẶT ĐÃ ĐƯỢC XÁC NHẬN(BÁC SĨ)
function getAppointmentForDoctor(endpoint) {
    fetch(endpoint).then(function (res) {
        return  res.json();
    }).then(function (data) {
        let d = document.getElementById("myAppointmentForDoctor");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                    <tr id="row${data[i][0]}">
                        <td>${data[i][9]}</td>
                        <td>${data[i][5]} ${data[i][6]}</td>
                        <td>
                            <a style="text-decoration: none;" href="/Web_QuanLyPhongMach/employees/medicalRecord/${data[i][4]}"><i class="fas fa-pencil-alt"></i>  Lập Phiếu</a>
                        </td>
                    </tr>
                    `;
            d.innerHTML = h;
        }

    }).catch(function (err) {
        console.error(err);
    });
}


function getAppointmentForNurse(endpoint) {
    fetch(endpoint).then(function (res) {
        return  res.json();
    }).then(function (data) {
        let d = document.getElementById("myAppointmentForNurse");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                    <tr id="row${data[i][0]}">
                        <td>${data[i][0]}</td>
                        <td>${data[i][5]} ${data[i][6]}</td>
                        <td>${moment(data[i][1]).format("DD/MM/YYYY")}</td>
                        <td>${data[i][2]}</td>
                        <td>
                            <input style="display: none" type="number" class="form-control" value="${data[i][0]}" name="idAppointment">
                                <button type="submit" class="btn btn-primary" >Xác nhận</button>
                        </td>
                    </tr>
                    `;
            d.innerHTML = h;
        }

    }).catch(function (err) {
        console.error(err);
    });
}