
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
    console.log(allNotices);
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
        var boardTitle = $('input[name="boardTitle"]').val();

        // Make AJAX request to the backend
        $.ajax({
            url: '/notices',
            type: 'GET',
            data: {
                boardTitle: boardTitle
            },
            success: function(data) {
                // Clear previous results
                $('#results').empty();

                // Append new results
                if (data.length > 0) {
                    $('#results').append('<table border="1"><thead><tr><td>번호</td><td>구분</td><td>제목</td><td>내용</td><td>이미지</td><td>작성자</td><td>등록일</td><td>조회수</td></tr></thead><tbody>');
                    data.forEach(function(notice) {
                        $('#results tbody').append(
                            '<tr>' +
                            '<td>' + notice.boardNo + '</td>' +
                            '<td>공지사항</td>' +
                            '<td><a href="/notices/edit/' + notice.boardNo + '">' + notice.boardTitle + '</a></td>' +
                            '<td>' + notice.boardContent + '</td>' +
                            '<td>' + notice.boardImage + '</td>' +
                            '<td>' + notice.boardWriter + '</td>' +
                            '<td>' + notice.boardDate + '</td>' +
                            '<td>' + notice.boardViewCount + '</td>' +
                            '</tr>'
                        );
                    });
                    $('#results').append('</tbody></table>');
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




