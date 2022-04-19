/**
 * Jquery - DisableAutoFill plugin
 * The easiest solution for disabling Google Chrome auto-fill, auto-complete functions.
 *
 * @license MIT
 * @version 1.2.4
 * @author  Terry, https://github.com/terrylinooo/
 * @updated 2018-08-01
 * @link    https://github.com/terrylinooo/jquery.disableAutoFill
 */

(function($) {

    'use strict';

    var realPassword = [];
    var realFields = [];

    // An Object for Helper functions.
    var _helper = {};

    // Extend the Array: add "insert" function.
    Array.prototype.insert = function (index, item) {
        this.splice(index, 0, item);
    };

    _helper.formSubmitListener = function(obj, settings) {
    	obj.on('submit', function(event) {
            _helper.restoreInput(obj, settings);            
    	});
    };
    
    /**
     * Helper function - ramdomizeInput
     * - Add random chars on "name" attribute to avid Browser remember what you submitted before.
     * 
     * @param {object} obj      jQuery DOM object (form)
     * @param {object} settings plugin settings.
     */
    _helper.randomizeInput = function(obj, settings) {
        try{
        	var formId = obj[0].id;
        	obj.find('input').each(function(i) {
                var fieldName = $(this).attr('name');
                var randomName = Math.random().toString(36).replace(/[^a-z]+/g, '');
                realFields.push({            	
                	"formId": formId,
                	"fieldName": fieldName,
                	"randomName" : randomName
                });
                $(this).attr('name', randomName);
            }); 
        }catch(err){
        	
        }    	         
    };

    /**
     * Helper function - restoreInput
     * - Remove random chars on "name" attribute, so we can submit correct data then.
     * - Restore password from star signs to original input password.
     *
     * @param {object} obj      jQuery DOM object (form)
     * @param {object} settings plugin settings.
     */
    _helper.restoreInput = function(obj, settings) {
        if (settings.randomizeInputName) {
            var formId = obj[0].id;
        	obj.find('input').each(function(i) {
                var randomName = $(this).attr('name');            	
            	for(var j in realFields){
            		var field = realFields[j].randomName;
            		var form = realFields[j].formId;
            		if((form == formId) && (field == randomName)){
            			$(this).attr('name', realFields[j].fieldName);
            		}
            	}            	
            });
        }       
    };

    /**
     * Core function
     */
    $.fn.disableAutoFill = function(options) {
        var settings = $.extend(
            {}, 
            $.fn.disableAutoFill.defaults, 
            options
        );

        // Add autocomplete attribute to form, and set it to 'off'
        this.attr('autocomplete', 'off');

        if (settings.randomizeInputName) {
            _helper.randomizeInput(this, settings);
        }
        _helper.formSubmitListener(this, settings);
        
    };

    $.fn.disableAutoFill.defaults = {
        randomizeInputName: true,        
        html5FormValidate: true,
        callback: function() {
            return true;
        },
    };

})(jQuery);