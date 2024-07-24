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
    if (notices.length > 0) {
        deleteNoticeBoards(notices);
    } else {
        alert('삭제할 항목을 선택하세요.');
    }
});

deleteAllBtn.addEventListener('click', () => {
    const allNotices = [...noticeList].map(notice => parseInt(notice.querySelector('.board-no').textContent));
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
    fetch('/notice', {
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

