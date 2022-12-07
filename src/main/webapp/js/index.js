function onclick_link(jsp_link) {
    let dist = document.getElementById('value').value; // change here: 여기 바꿔서 value 넣기
    if (dist !== "" || (typeof jsp_link  === "undefined" || jsp_link.length === 0)) {
        // console.log("함수가 잘 동작합니다: if절");
        window.location.href = `${jsp_link}.jsp?key=${dist}`; // change here: 이름들 바꿔서 get 요소 바꿔주기
    } else
        // console.log("함수가 잘 동작합니다: else절");
        alert('Oops!! 링크가 없어요!'); // 실사용시 활성화
}
