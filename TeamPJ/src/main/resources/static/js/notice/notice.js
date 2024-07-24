// const delBtn = document.getElementById('deleteSelectedBtn') // 삭제 버튼
// const searchBtn = document.getElementsByClassName('rental-searchBtn') // 검색 버튼
// const pageList = document.getElementsByClassName('rental-table-list-footer'); // 페이지 리스트 버튼
// const noticeList = document.getElementsByClassName('rental-table-boards');
// const searchBox = document.getElementsByClassName('search-tag-result'); //검색창
// const allSelectBtn = document.querySelector('rental-table-list-head input[type="checkbox"]');


const delBtn = document.getElementById('deleteSelectedBtn');
const deleteAllBtn = document.getElementById('deleteAllBtn');
const noticeList = document.getElementsByClassName('rental-table-boards');
const allSelectBtn = document.getElementById('checkboxAll');

allSelectBtn.addEventListener('click', () => {
    const isChecked = allSelectBtn.checked;
    [...noticeList].forEach(notice => {
        const checkBoxInput = notice.querySelector('input[type="checkbox"]');
        checkBoxInput.checked = isChecked;
    });
});

delBtn.addEventListener('click', () => {
    const notices = collectNoticeSelectedBoards();
    console.log(notices);
    if (notices.length > 0) {
        deleteNoticeBoards(notices);
    } else {
        alert('삭제할 항목을 선택하세요.');
    }
});

deleteAllBtn.addEventListener('click', () => {
    const allNotices = [...noticeList].map(notice => parseInt(notice.querySelector('.board-no').textContent));
    console.log(allNotices)
    if (allNotices.length > 0) {
        deleteNoticeBoards(allNotices);
    } else {
        alert('삭제할 항목이 없습니다.');
    }
});

function collectNoticeSelectedBoards() {
    return [...noticeList]
        .filter(notice => notice.querySelector('input[type="checkbox"]').checked)
        .map(notice => parseInt(notice.querySelector('.board-no').textContent));
}

function deleteNoticeBoards(notices) {
    fetch('/Notice_Service/notice', {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(notices)
    }).then(response => {
        if (response.ok) {
            alert('삭제가 완료되었습니다.');
            location.reload();
        } else {
            alert('삭제에 실패했습니다.');
        }
    });
}

$(document).ready(function() {
    $('#searchForm').on('submit', function(event) {
        event.preventDefault(); // Prevent form submission

        // Get form data
        var boardNo = $('#boardNo').val();
        var boardTitle = $('#boardTitle').val();

        // Make AJAX request to the backend
        $.ajax({
            url: '/notices',
            type: 'GET',
            data: {
                boardNo: boardNo,
                boardTitle: boardTitle
            },
            success: function(data) {
                // Clear previous results
                $('#results').empty();

                // Append new results
                if (data.length > 0) {
                    data.forEach(function(notice) {
                        $('#results').append('<p>' + JSON.stringify(notice) + '</p>');
                    });
                } else {
                    $('#results').append('<p>No results found</p>');
                }
            },
            error: function(error) {
                $('#results').empty();
                $('#results').append('<p>An error occurred</p>');
            }
        });
    });
});
// console.log(noticeList.length);
// allSelectBtn.addEventListener('click', () => {
//     console.log('클릭');
//     [...noticeList].forEach(notice => {
//         const checkBoxInput = notice.querySelector('input[type="checkbox"]');
//         checkBoxInput.checked = allSelectBtn.checked;
//         checkBoxInput.addEventListener('click', () => {
//             // 다른 체크박스가 해제되면 전체 선택 체크박스 해제
//             if (!checkBoxInput.checked) {
//                 allSelectBtn.checked = false;
//             }
//         });
//     });
// });
//
// // 선택 삭제 버튼 눌렀을 때
// delBtn.addEventListener('click', () => {
//     const notices = collect_notice_selected_boards();
//     if(notices.length <= 0){
//         alert('비품을 하나이상 선택해주세요');
//         return;
//     }
//
//     console.log("나와라: " + JSON.stringify(notices, null, 2));
//     delete_notice_boards(notices);
// });
//
//
// // 선택되어있는 비품들을 수집
// function collect_notice_selected_boards(){
//     const notices = []; // 비품 번호들을 가지는 리스트
//     // 모든 비품들을 순회한다
//     [...noticeList].forEach(notice => {
//         const checkBoxInput = notice.querySelector('input[type="checkbox"]');
//         // 비품이 선택되어있다면
//         console.log(checkBoxInput.checked);
//         if(checkBoxInput.checked) {
//             const boardNo = +notice.querySelector('.board-no').textContent;
//             // const name = product.querySelector('.name').textContent;
//             // const category = product.querySelector('.category').textContent;
//             // const amount = +product.querySelector('.amount').textContent;
//             // const purchaseDate = product.querySelector('.purchase-date').textContent;
//             // const supplier = product.querySelector('.supplier').textContent;
//             // const price = +product.querySelector('.price').textContent;
//             // const description = product.querySelector('.description').textContent;
//             notices.push({
//                 boardNo
//                 // productName: name,
//                 // productCategory: category,
//                 // productAmount: amount,
//                 // productPurchaseDate: purchaseDate,
//                 // productSupplier: supplier,
//                 // productPrice: price,
//                 // productDescription: description
//             });
//             console.log(boardNo);
//         }
//     });
//     console.log(notices);
//     return notices;
// }

// // 선택되어 있는 비품 아이템을 삭제
// function delete_notice_boards(notices){
//     fetch(`/Notice_Service/notice`,{
//         method: "DELETE",
//         headers: {
//             "Content-Type": "application/json",
//             // "X-CSRF-TOKEN": csrfTokenInput.value
//         },
//         body: JSON.stringify(notices)
//     }).then(response => {
//         if(response.ok){
//             alert('비품을 삭제하였습니다');
//             location.reload(); // 화면 새로고침
//         }
//     });
// }

// const requestObject = {
// "GET_ALL": function () {
//     fetch(`/notice`)
//         .then(response => response.json())
//         .then(notice => {
//             alert('조회가 완료되었습니다!');
//             modify_notice(notice);
//         });
// },
// "GET": function () {
//     fetch(`/notice/${ser.value}`)
//         .then(response => {
//             // 응답코드가 200이 왔음
//             if (response.status === 200) {
//                 // 다음 then을 실행하라.
//                 return response.json()
//             } else {
//                 throw new Error('해당 책 정보가 존재하지 않습니다..')
//             }
//         })
//         .then(
//             // 에러 발생이 아닐 때 자동실행됨
//             notice => {
//                 console.log(notice);
//                 alert('조회완료!');
//                 modify_notice([notice]);
//             },
//             // 에러 발생일 때 자동실행됨
//             error => {
//                 alert(error);
//             }
//         );
// },


// delBtn.onclick = () => {
//     fetch(`notice/{boardNo}`, {
//         method: "DELETE"
//     }).then(response => {
//         if (response.status === 200) {
//             alert('삭제가 완료되었습니다!');
//             // requestObject.GET_ALL(); // 전부 재 조회
//         } else if (response.status === 204) {
//             alert('해당 게시판 정보는 존재하지 않습니다..');
//         }
//         console.log(delBtn);
//     });
// }

//     requestObject.GET_ALL();
//     // 모든 책을 가져오는 버튼 클릭
//     searchBtn.onclick = requestObject.GET_ALL;
//     // 하나의 제목과 내용을 가져오는 버튼 클릭
//     searchBtn.onclick = requestObject.GET;
// // 하나의 책을 등록하는 버튼 클릭
// searchBtn.onclick = () => {
//     const notice = {
//         board : boards.value};
//     requestObject.POST(notice);
// }
// // 하나의 책을 수정하는 버튼 클릭
// searchBtn.onclick = () => {
//     // 제목에 뭔가 작성했다면
//     if(boards.value !== undefined && boards.value !== ''){
//         // PUT 요청을 한다
//         const notice = {
//             searchBox : boards.value};
//         requestObject.PUT(notice);
//     }
//     // // 가격만 작성되어있다면 PATCH 요청을 한다
//     // else if( /^[0-9]+$/.test(.value) ){
//     //         requestObject.PATCH();
//     //     }
//     }
//     // 하나의 게시판을 삭제한다 버튼 클릭
// deleteAllBtn.onclick = () => {
//     requestObject.DELETE();
//     }
//
//
//
// // 하나의 게시판 삭제
// deleteAllBtn.onclick = () => {
//     requestObject.DELETE();
// }
// function modify_notice(notices) {
//     const table = document.querySelector('table');
//     const tBody = table.tBodies[0];
//     tBody.innerHTML = ''; // tbody 내용 전부 삭제
//     // 모든 게시판 정보를 순회한다
//     for (let i = 0; i < notices.length; i++) {
//         // 책 하나당 tr 하나임
//         const tr = tBody.insertRow(i);
//         // tr 하나의 td 내용은 게시판의 내용들
//         tr.insertCell(0).textContent = notices[i].boardNo;
//         tr.insertCell(1).textContent = notices[i].boardCategory;
//         tr.insertCell(2).textContent = notices[i].boardTitle;
//         tr.insertCell(3).textContent = notices[i].boardContent;
//         tr.insertCell(4).textContent = notices[i].boardImage;
//         tr.insertCell(5).textContent = notices[i].boardWriter;
//         tr.insertCell(6).textContent = notices[i].boardDate;
//         tr.insertCell(7).textContent = notices[i].boardViewCount;
//     }
// }



