/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function getAdmin(endpoint) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.info(data);
        let h = "";
        for (let i = 0; i < data.length; i++)
            h += `
                <tr id="row${data[i].id}">
                    <td>${i + 1}</td>
                    <td>${data[i].firstName}</td>
                    <td>${data[i].lastName}</td>
                    <td>${moment(data[i].dateOfBirth).format("DD/MM/YYYY")}</td>
                    <td>${data[i].sex}</td>
                    <td>${data[i].phone}</td>
                    <td>${data[i].position}</td>
                    <td>
                        <div class="spinner-border text-secondary" style="display:none" id="load${data[i].id}"></div>
                    </td>
                    <td>
                        <i class="fas fa-info-circle" data-bs-toggle="modal" onclick="detailAdmin('${endpoint}', ${data[i].id})"></i>
                    </td>
                    <td>
                        <a style="color:black" href="/Web_QuanLyPhongMach/admins/updateAdmin/${data[i].id}"><i class="fas fa-pencil-alt"></i></a>
                    </td>
                    <td>
                        <i onclick="deleteAdmin('${endpoint + "/" + data[i].id}', ${data[i].id}, this)" class="fas fa-trash-alt"></i>
                    </td>
                </tr>
        `

        let d = document.getElementById("myAdmin");
        d.innerHTML = h;
    }).catch(function (err) {
        console.error(err);
    });
}

function deleteAdmin(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`);
    let load = document.getElementById(`load${id}`);
    load.style.display = "block";
    btn.style.display = "none";
    fetch(endpoint, {
        method: "delete"
    }).then(function (res) {
//        if (res.status === 204)
//            alert("Đang gặp sự cố !");
        load.style.display = "none";
        r.style.display = "none";
    }).catch(function (err) {
        console.error(err);
        load.style.display = "none";
        btn.style.display = "block";
    })
}


function detailAdmin(endpoint, id) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        console.info(data);
        let h = "";
        for (let i = 0; i < data.length; i++)
            if (data[i].id == id)
            {
                h += `
                <div style="text-align: center" class="boder rounded bg-light"> 
                    <img
                        src="${data[i].image}"
                        class="rounded-circle"
                        height="70"
                        width="70"
                        alt="Black and White Portrait of a Man"
                        loading="lazy"
                        />
                    <h6>${data[i].firstName} ${data[i].lastName}</h6>
                </div>

                <div>
                    <h6>Ngày sinh: ${moment(data[i].dateOfBirth).format("DD/MM/YYYY")}</h6>
                    <h6>Giới tính: ${data[i].sex}</h6>
                    <h6>Vai Trò: ${data[i].position}</h6> 
                    <h6>Địa chỉ: ${data[i].address}</h6>
                    <h6>Email: ${data[i].email}</h6>
                    <h6>Phone: ${data[i].phone}</h6>
                    <h6>Username: ${data[i].username}</h6>
                </div>
            `
            }
        let d = document.getElementById("detailAdmin");
        d.innerHTML = h;
    }).catch(function (err) {
        console.error(err);
    });
    $('#detailModal').modal('show');
}


//Trường xữ lý lổi của form Add

const firstname = document.getElementById("firstName");
const lastname = document.getElementById("lastName");
const email = document.getElementById("email");
const phone = document.getElementById("phone");
const username = document.getElementById("username");
const password = document.getElementById("password");
const confirmPassword = document.getElementById("confirmPassword");
const dateOfBirth = document.getElementById("dateOfBirth");

const btSubmit = document.getElementById('btnAdd');
const inputEls = document.querySelectorAll('.input-row');

var temp = 0;
btSubmit.addEventListener('click', function () {
    Array.from(inputEls).map((ele) =>
        ele.classList.remove('error'));

    //nếu còn lỗi --> không load lại trang
    let flag = checkValidate();
    if (!flag)
    {
        $(document).ready(function () {
            $('#myFormAdd').submit(function (e) {
                e.preventDefault();
            });
        });
        temp++;
    }

    if (flag && temp >= 1)
    {
        var formData = new FormData($('#myFormAdd')[0]);
        $(document).ready(function () {
            $('form').submit(function () {
                $.ajax({
                    method: $(this).attr('method'),
                    url: $(this).attr('action'),
                    data: formData,
                    async: false,
                    cache: false,
                    processData: false,
                    contentType: false
                });
            });
        });
        alert('Gửi đăng ký thành công !');
        window.location = "/Web_QuanLyPhongMach/admins/adminsManager";
    }

    if (flag && temp <= 0)
    {
        alert('Gửi đăng ký thành công !!');
        window.location = "/Web_QuanLyPhongMach/admins/adminsManager";
    }
});



//Kiểm tra lổi
function checkValidate() {
    let fn = firstname.value;
    let ln = lastname.value;
    let eml = email.value;
    let phn = phone.value;
    let user = username.value;
    let pass = password.value;
    let confpass = confirmPassword.value;
    let dateOfB = dateOfBirth.value;

    let isCheck = true;

    if (fn === '') {
        setError(firstname, 'Họ và tên đệm không được để trống');
        isCheck = false;
    }

    if (fn.length > 24) {
        setError(firstname, 'Họ và tên đệm không lớn hơn 24 ký tự');
        isCheck = false;
    }

    if (ln === '') {
        setError(lastname, 'Tên không được để trống');
        isCheck = false;
    }

    if (ln.length > 24) {
        setError(lastname, 'Tên không lớn hơn 24 ký tự');
        isCheck = false;
    }

    if (user === '') {
        setError(username, 'Tài khoản không được để trống');
        isCheck = false;
    }

    if (pass === '') {
        setError(password, 'Mật khẩu không được để trống');
        isCheck = false;
    }

    if (confpass === '') {
        setError(confirmPassword, 'Mật khẩu không được để trống');
        isCheck = false;
    }

    if (confpass !== pass) {
        setError(confirmPassword, 'Mật khẩu không chính xác');
        isCheck = false;
    }

    if (eml === '') {
        setError(email, 'Email không được để trống');
        isCheck = false;
    } else if (!isEmail(eml)) {
        setError(email, 'Email không đúng định dạng');
        isCheck = false;
    }

    if (phn === '') {
        setError(phone, 'Số điện thoại không được để trống');
        isCheck = false;
    } else if (!isPhone(phn)) {
        setError(phone, 'Số điện thoại không đúng định dạng');
        isCheck = false;
    }

    var todayCheck = new Date();
    todayCheck.setDate(todayCheck.getDate() - 1);
    var dateOfBirthCheck = new Date(dateOfB);

    if (dateOfB === "") {
        setError(dateOfBirth, 'Ngày không hợp lệ!');
        isCheck = false;
    }
    // Kiểm tra ngày sinh
    if (dateOfBirthCheck >= todayCheck) {
        setError(dateOfBirth, 'Ngày không hợp lệ!!');
        isCheck = false;
    }

    return isCheck;
}

function setError(e, message) {
    let parentEle = e.parentNode;
    parentEle.classList.add('error');
    parentEle.querySelector('small').innerText = message;
}

//kiểm tra email có hợp lệ
function isEmail(eml) {
    return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(eml);
}
//kiểm tra số điẹn thoại có hợp lệ
function isPhone(nb) {
    return /(84|0[3|5|7|8|9])+([0-9]{8})\b/.test(nb);
}
