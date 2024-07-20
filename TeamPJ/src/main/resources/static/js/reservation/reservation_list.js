
function reservation_update(button) {
const reservationNo = button.getAttribute('data-reservation-no');
console.log(reservationNo);
    if (!reservationNo) {
        alert('예약 번호를 찾을 수 없습니다.');
        return;
    }
    fetch(`/reservation/list/${reservationNo}`, {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
    }).then(response => {
        if (response.ok) {
            alert('승인되었습니다.');
            location.reload();
        }
    })
}

function reservation_delete(button) {
    const reservationNo = button.getAttribute('data-reservation-no');
    console.log(reservationNo);
    fetch(`/reservation/list/${reservationNo}`, {
        method: "DELETE"
    }).then(response => {
        if (response.ok) {
            alert('거부되었습니다.');
            location.reload();
        }
    })
}


// 승인 클릭 시 승인 Status 업데이트
// function reservation_update(item, status){
//     if(status == null){
//         fetch("/reservation/list",{
//             method: "PUT",
//             headers: {
//                 "Content-Type": "application/json",
//                 // "X-CSRF-TOKEN": csrfTokenInput.value
//             },
//             body: JSON.stringify(item)
//         }).then(response => {
//             if(response.ok){
//                 alert('승인되었습니다.');
//                 location.reload(); // 화면 새로고침
//             }
//         });
//     }
//
// }

// 거부 클릭 시 칼럼 삭제
// function reservation_delete(item){
//     fetch("/reservation/list",{
//         method: "DELETE",
//         headers: {
//             "Content-Type": "application/json",
//             // "X-CSRF-TOKEN": csrfTokenInput.value
//         },
//         body: JSON.stringify(item)
//     }).then(response => {
//         if(response.ok){
//             console.log(item)
//             alert('거부되었습니다.');
//             location.reload(); // 화면 새로고침
//         }
//     });
// }

