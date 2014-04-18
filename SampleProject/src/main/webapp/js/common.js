function makeAJaxCall(targetId, url, formId) {
    $.ajax({
        url: url,
        type: 'POST',
        data: jQuery('#'+formId).serialize(),
        dataType: 'html',
        success: function(responseData) {
            jQuery('#'+targetId).innerHTML = responseData;
        }
    });
}
