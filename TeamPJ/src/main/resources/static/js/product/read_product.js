const  form = document.forms.namedItem('update-form');
const updateBtn = document.getElementById("update");

updateBtn.onclick = () => {
    if(updateBtn.innerText === '확인'){
        confirm('수정완료 하시겠습니까?');
        form.submit();
    }
    else{
        const h2Tag = document.querySelector('h2');
        const inputTags = document.querySelectorAll('input');
        confirm('수정화면으로 이동하시겠습니까?');
        updateBtn.innerText = '확인';
        h2Tag.innerText = '비품 수정';
        inputTags.forEach(input => {
           input.removeAttribute('readonly');
        });
    }
}

// 구매일 날짜 jquery
$.datepicker.setDefaults({
    dateFormat: 'yy-mm-dd',
    prevText: '이전 달',
    nextText: '다음 달',
    monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
    dayNames: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
    dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
    showMonthAfterYear: true,
    yearSuffix: '년'
});

$(function () {
    $('.datepicker').datepicker();
});
