  var _ = require('underscore');

  function sayHello() {
    console.log('Hello, World');
  }

   _.times(5, sayHello);

  var str = "subbalakshmi iyer cute"
   console.log(str.length)

  var string = convertTitleCase(str)
  console.log(convertTitleCase(str))

    function convertTitleCase(str){
      return str.replace(/\w\S*,str.charAt(0).toUpperCase()+str.substr(1).toLowerCase());
    }


  function convertTitleCase(str) {
    return str.split(' ').map(function(val){
      return val.charAt(0).toUpperCase() + val.substr(1).toLowerCase();
    }).join(' ');
  }



   const arr = [10, 12, 15, 21];
    for (var i = 0; i < arr.length; i++) {
        using the ES6 let syntax, it creates a new binding
        every single time the function is called
        read more here: http: exploringjs.com/es6/ch_variables.html#sec_let-const-loop-heads
      setTimeout(function() {
        console.log('The index of this number is: ' + i+' '+arr[i]);
      }, 30);
    }


      interviewer: what will the following code output?
     const arr = [10, 12, 15, 21];
    for (let i = 0; i < arr.length; i++) {
      setTimeout(function() {
        console.log('Index: ' + i + ', element: ' + arr[i]);
      }, 30);
    }




  var validation_messages = {
      "key_1": {
          "your_name": "jimmy",
          "your_msg": "hello world"
      },
      "key_2": {
          "your_name": "billy",
          "your_msg": "foo equals bar"
      },
    key_3 :
      "hello"

  }

    Object.keys(validation_messages).map(idx=>{
      console.log(idx+': ')
      Object.keys(validation_messages[idx]).map(idx2=>{
        console.log(idx2, validation_messages[idx][idx2])
      })
    })

    console.log(typeof arr[0])

    console.log(someFunc())

    function someFunc() {
    if(arr.includes(15))
      return arr.indexOf(15)
    return "Nope"
    }

  for(let prop in validation_messages){
   console.log(prop,validation_messages[prop])
  }
