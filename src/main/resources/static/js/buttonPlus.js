$(document).ready(function () {
  $(".minus").click(function () {
    var $input = $(this).parent().find("input");
    var count = parseInt($input.val()) - 1;
    count = count < 1 ? 1 : count;
    $input.val(count);
    $input.change();
    return false;
  });
  $(".plus").click(function () {
    var $input = $(this).parent().find("input");
    $input.val(parseInt($input.val()) + 1);
    $input.change();
    return false;
  });
});

const button = document.querySelector(".addtocart");
const done = document.querySelector(".done");
console.log(button);
let added = false;
button.addEventListener("click", () => {
  if (added) {
    done.style.transform = "translate(-110%) skew(-40deg)";
    added = false;
  } else {
    done.style.transform = "translate(0px)";
    added = true;
  }
});
