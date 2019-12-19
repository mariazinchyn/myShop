function appHandleError(err){
    if (err.responseJson) {
        alert(err.responseJson.message)
    } else{
        alert('something wrong')
    }
}

function appGetTest16(file) {
    return new Promise((resolve, reject) => {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => resolve(reader.result);
        reader.onerror = error => reject(error);
    });
}