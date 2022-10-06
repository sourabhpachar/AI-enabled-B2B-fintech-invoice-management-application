var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("add-button");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
  modal.style.display = "block";
}


span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
//edit button
var btn = document.getElementById("edit-button");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}





function onFormSubmit() {
    
        var formData = readFormData();
        insertNewRecord(formData);
    }


    function readFormData() {
      var formData = {};
      formData["customername"] = document.getElementById("customername").value;
      formData["DueDate"] = document.getElementById("DueDate").value;
      formData["CustomerNo"] = document.getElementById("CustomerNo").value;
      formData["Notes"] = document.getElementById("Notes").value;
      formData["InvoiceNo"] = document.getElementById("InvoiceNo").value;
      formData["InvoiceAmount"] = document.getElementById("InvoiceAmount").value;
      
      return formData;
  }
  
  function insertNewRecord(data) {
      var table = document.getElementById("customer").getElementsByTagName('tbody')[0];
      var newRow = table.insertRow(table.length);
      cell1 = newRow.insertCell(0);
      cell1.innerHTML = data.customername;
      cell2 = newRow.insertCell(1);
      cell2.innerHTML = data.CustomerNo;
      cell3 = newRow.insertCell(2);
      cell3.innerHTML = data.InvoiceNo;
      cell4 = newRow.insertCell(3);
      cell4.innerHTML = data.InvoiceAmount;
      cell5 = newRow.insertCell(4);
      cell5.innerHTML = data.DueDate;
      cell6 = newRow.insertCell(5);
      cell6.innerHTML = data.Notes;
    
}