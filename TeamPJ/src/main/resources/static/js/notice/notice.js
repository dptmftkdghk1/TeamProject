const delAllBtn = document.getElementById('deleteAllBtn'); // 전체삭제 버튼
const delBtn = document.getElementById('deleteSelectedBtn') // 선택삭제 버튼
const searchBtn = document.getElementsByClassName('rental-searchBtn') // 검색 버튼
const pageList = document.getElementsByClassName('rental-table-list-footer'); // 페이지 리스트 버튼

const searchBox = document.getElementsByClassName('search-tag-result'); //검색창



const requestObject = {
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

    delAllBtn.onclick = () => {
        fetch(`/notice`, {
            method: "DELETE"
        }).then(response => {
            if (response.status === 200) {
                alert('삭제가 완료되었습니다!');
                // requestObject.GET_ALL(); // 전부 재 조회
            } else if (response.status === 204) {
                alert('해당 게시판 정보는 존재하지 않습니다..');
            }
        });
    }

    delAllBtn.onclick = () => {
        fetch(`/notice`, {
            method: "DELETE"
        }).then(response => {
            if (response.status === 200) {
                alert('삭제가 완료되었습니다!');
                // requestObject.GET_ALL(); // 전부 재 조회
            } else if (response.status === 204) {
                alert('해당 게시판 정보는 존재하지 않습니다..');
            }
        });
    },
}
    requestObject.GET_ALL();
    // 모든 책을 가져오는 버튼 클릭
    searchBtn.onclick = requestObject.GET_ALL;
    // 하나의 제목과 내용을 가져오는 버튼 클릭
    searchBtn.onclick = requestObject.GET;
// 하나의 책을 등록하는 버튼 클릭
searchBtn.onclick = () => {
    const notice = {
        board : boards.value};
    requestObject.POST(notice);
}
// 하나의 책을 수정하는 버튼 클릭
searchBtn.onclick = () => {
    // 제목에 뭔가 작성했다면
    if(boards.value !== undefined && boards.value !== ''){
        // PUT 요청을 한다
        const notice = {
            searchBox : boards.value};
        requestObject.PUT(notice);
    }
    // // 가격만 작성되어있다면 PATCH 요청을 한다
    // else if( /^[0-9]+$/.test(.value) ){
    //         requestObject.PATCH();
    //     }
    }
    // 하나의 게시판을 삭제한다 버튼 클릭
deleteAllBtn.onclick = () => {
    requestObject.DELETE();
    }



// 하나의 게시판 삭제
deleteAllBtn.onclick = () => {
    requestObject.DELETE();
}
function modify_notice(notices) {
    const table = document.querySelector('table');
    const tBody = table.tBodies[0];
    tBody.innerHTML = ''; // tbody 내용 전부 삭제
    // 모든 게시판 정보를 순회한다
    for (let i = 0; i < notices.length; i++) {
        // 책 하나당 tr 하나임
        const tr = tBody.insertRow(i);
        // tr 하나의 td 내용은 게시판의 내용들
        tr.insertCell(0).textContent = notices[i].boardNo;
        tr.insertCell(1).textContent = notices[i].boardCategory;
        tr.insertCell(2).textContent = notices[i].boardTitle;
        tr.insertCell(3).textContent = notices[i].boardContent;
        tr.insertCell(4).textContent = notices[i].boardImage;
        tr.insertCell(5).textContent = notices[i].boardWriter;
        tr.insertCell(6).textContent = notices[i].boardDate;
        tr.insertCell(7).textContent = notices[i].boardViewCount;
    }
}



