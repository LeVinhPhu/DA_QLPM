/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

//LẤY PHIẾU KHÁM BỆNH
function getMedicalRecord(endpoint) {
    fetch(endpoint).then(function (res) {
        return  res.json();
    }).then(function (data) {
        let d = document.getElementById("myMedicalRecord");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                    <tr>
                        <td>${data[i][0]}</td>
                        <td>${data[i][1]} ${data[i][2]}</td>
                        <td>
                            <a href="/Web_QuanLyPhongMach/employees/prescription/${data[i][0]}">Kê toa thuốc</a>
                        </td>
                    </tr>
                    `;
            d.innerHTML = h;
        }

    }).catch(function (err) {
        console.error(err);
    });
}