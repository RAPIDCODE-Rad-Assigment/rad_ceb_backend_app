//REVOLUTION SLIDER FUNCTIONS ===== //
var revapi318,
    tpj = jQuery;

function dz_rev_slider_1() {
    if (tpj("#webmax-one").revolution === undefined) {
        revslider_showDoubleJqueryError("#webmax-one");
    } else {
        revapi318 = tpj("#webmax-one").show().revolution({
            sliderType: "standard",
            jsFileLocation: "//server.local/revslider/wp-content/plugins/revslider/public/assets/js/",
            sliderLayout: "auto",
            dottedOverlay: "none",
            delay: 5000,
            navigation: {
                keyboardNavigation: "off",
                keyboard_direction: "horizontal",
                mouseScrollNavigation: "off",
                mouseScrollReverse: "default",
                onHoverStop: "off",
                touch: {
                    touchenabled: "on",
                    touchOnDesktop: "off",
                    swipe_threshold: 75,
                    swipe_min_touches: 1,
                    swipe_direction: "horizontal",
                    drag_block_vertical: false
                }
                ,
                arrows: {
                    style: "metis",
                    enable: true,
                    hide_onmobile: false,
                    //hide_under:778,
                    hide_onleave: false,
                    //tmp:'<div class="tp-arr-allwrapper"><div class="tp-arr-imgholder"></div></div>',
                    left: {
                        h_align: "left",
                        v_align: "bottom",
                        h_offset: 20,
                        v_offset: 20,
                    },
                    right: {
                        h_align: "left",
                        v_align: "bottom",
                        h_offset: 90,
                        v_offset: 20,
                    }
                }
                ,
                bullets: {
                    enable: true,
                    hide_onmobile: false,
                    style: "bullet-bar",
                    hide_onleave: false,
                    direction: "vertical",
                    h_align: "right",
                    v_align: "center",
                    h_offset: 30,
                    v_offset: 0,
                    space: 5,
                    tmp: ''
                }

            },
            viewPort: {
                enable: true,
                outof: "wait",
                visible_area: "80%",
                presize: true
            },
            responsiveLevels: [1240, 1024, 778, 480],
            visibilityLevels: [1240, 1024, 778, 480],
            gridwidth: [1240, 1024, 778, 480],
            gridheight: [840, 700, 700, 700],
            lazyType: "single",
            parallax: {
                type: "scroll",
                origo: "slidercenter",
                speed: 400,
                levels: [5, 10, 15, 20, 25, 30, 35, 40, 45, 46, 47, 48, 49, 50, 51, 55],
            },
            shadow: 0,
            spinner: "spinner3",
            stopLoop: "off",
            stopAfterLoops: -1,
            stopAtSlide: 1,
            shuffle: "off",
            autoHeight: "off",
            fullScreenAutoWidth: "off",
            fullScreenAlignForce: "off",
            fullScreenOffsetContainer: ".site-header",
            fullScreenOffset: "0px",
            disableProgressBar: "on",
            hideThumbsOnMobile: "off",
            hideSliderAtLimit: 0,
            hideCaptionAtLimit: 0,
            hideAllCaptionAtLilmit: 0,
            debugMode: false,
            fallbacks: {
                simplifyAll: "off",
                nextSlideOnWindowFocus: "off",
                disableFocusListener: false,
            }
        });
    }
    try { initSocialSharing("318") } catch (e) { }
}

function dz_rev_slider_2() {
	if (tpj("#webmax-two").revolution === undefined) {
		revslider_showDoubleJqueryError("#webmax-two");
	} else {
		revapi318 = tpj("#webmax-two").show().revolution({
			sliderType: "standard",
			jsFileLocation: "//server.local/revslider/wp-content/plugins/revslider/public/assets/js/",
			sliderLayout: "auto",
			dottedOverlay: "none",
			delay: 5000,
			navigation: {
				keyboardNavigation: "off",
				keyboard_direction: "horizontal",
				mouseScrollNavigation: "off",
				mouseScrollReverse: "default",
				onHoverStop: "off",
				touch: {
					touchenabled: "on",
					touchOnDesktop: "off",
					swipe_threshold: 75,
					swipe_min_touches: 1,
					swipe_direction: "horizontal",
					drag_block_vertical: false
				}
				,
				arrows: {
					style: "metis",
					enable: true,
					hide_onmobile: false,
					//hide_under:778,
					hide_onleave: false,
					//tmp:'<div class="tp-arr-allwrapper"><div class="tp-arr-imgholder"></div></div>',
					left: {
						h_align: "left",
						v_align: "bottom",
						h_offset: 20,
						v_offset: 20,
					},
					right: {
						h_align: "left",
						v_align: "bottom",
						h_offset: 90,
						v_offset: 20,
					}
				}
				,
				bullets: {
					enable: true,
					hide_onmobile: false,
					style: "bullet-bar",
					hide_onleave: false,
					direction: "vertical",
					h_align: "right",
					v_align: "center",
					h_offset: 30,
					v_offset: 0,
					space: 5,
					tmp: ''
				}

			},
			viewPort: {
				enable: true,
				outof: "wait",
				visible_area: "80%",
				presize: true
			},
			responsiveLevels: [1240, 1024, 778, 480],
			visibilityLevels: [1240, 1024, 778, 480],
			gridwidth: [1240, 1024, 778, 480],
			gridheight: [840, 700, 700, 700],
			lazyType: "single",
			parallax: {
				type: "scroll",
				origo: "slidercenter",
				speed: 400,
				levels: [5, 10, 15, 20, 25, 30, 35, 40, 45, 46, 47, 48, 49, 50, 51, 55],
			},
			shadow: 0,
			spinner: "spinner3",
			stopLoop: "off",
			stopAfterLoops: -1,
			stopAtSlide: 1,
			shuffle: "off",
			autoHeight: "off",
			fullScreenAutoWidth: "off",
			fullScreenAlignForce: "off",
			fullScreenOffsetContainer: ".site-header",
			fullScreenOffset: "0px",
			disableProgressBar: "on",
			hideThumbsOnMobile: "off",
			hideSliderAtLimit: 0,
			hideCaptionAtLimit: 0,
			hideAllCaptionAtLilmit: 0,
			debugMode: false,
			fallbacks: {
				simplifyAll: "off",
				nextSlideOnWindowFocus: "off",
				disableFocusListener: false,
			}
		});
	}
	try { initSocialSharing("318") } catch (e) { }
}

function dz_rev_slider_3() {
	if (tpj("#webmax-three").revolution === undefined) {
		revslider_showDoubleJqueryError("#webmax-three");
	} else {
		revapi318 = tpj("#webmax-three").show().revolution({
			sliderType: "standard",
			jsFileLocation: "//server.local/revslider/wp-content/plugins/revslider/public/assets/js/",
			sliderLayout: "fullscreen",
			dottedOverlay: "none",
			delay: 5000,
			navigation: {
				keyboardNavigation: "off",
				keyboard_direction: "horizontal",
				mouseScrollNavigation: "off",
				mouseScrollReverse: "default",
				onHoverStop: "off",
				touch: {
					touchenabled: "on",
					touchOnDesktop: "off",
					swipe_threshold: 75,
					swipe_min_touches: 1,
					swipe_direction: "horizontal",
					drag_block_vertical: false
				}
				,
				arrows: {
					style: 'ares',
					tmp: '<div class="tp-title-wrap"><span class="tp-arr-titleholder">{{title}}</span></div>',
					enable: true,
					hide_onmobile: false,
					hide_under: 778,
					hide_onleave: false,

					left: {
						h_align: "left",
						v_align: "center",
						h_offset: 20,
						v_offset: 20,
					},
					right: {
						h_align: "right",
						v_align: "center",
						h_offset: 20,
						v_offset: 20,
					}
				}
				,
				bullets: {
					enable: true,
					hide_onmobile: false,
					style: 'hermes',
					hide_onleave: false,
					//direction:"vertical",
					h_align: "center",
					v_align: "botom",
					h_offset: 0,
					v_offset: 30,
					space: 5,
					tmp: ''
				}

			},
			viewPort: {
				enable: true,
				outof: "wait",
				visible_area: "80%",
				presize: true
			},
			responsiveLevels: [1240, 1024, 778, 480],
			visibilityLevels: [1240, 1024, 778, 480],
			gridwidth: [1240, 1024, 778, 480],
			gridheight: [840, 700, 700, 700],
			lazyType: "single",
			parallax: {
				type: "scroll",
				origo: "slidercenter",
				speed: 400,
				levels: [5, 10, 15, 20, 25, 30, 35, 40, 45, 46, 47, 48, 49, 50, 51, 55],
			},
			shadow: 0,
			spinner: "spinner3",
			stopLoop: "off",
			stopAfterLoops: -1,
			stopAtSlide: 1,
			shuffle: "off",
			autoHeight: "off",
			fullScreenAutoWidth: "off",
			fullScreenAlignForce: "off",
			fullScreenOffsetContainer: ".site-header",
			fullScreenOffset: "0px",
			disableProgressBar: "on",
			hideThumbsOnMobile: "off",
			hideSliderAtLimit: 0,
			hideCaptionAtLimit: 0,
			hideAllCaptionAtLilmit: 0,
			debugMode: false,
			fallbacks: {
				simplifyAll: "off",
				nextSlideOnWindowFocus: "off",
				disableFocusListener: false,
			}
		});
	}
	try { initSocialSharing("318") } catch (e) { }
}

function dz_rev_slider_4() {
	if (tpj("#welcome").revolution === undefined) {
		revslider_showDoubleJqueryError("#welcome");
	} else {
		revapi318 = tpj("#welcome").show().revolution({
			sliderType: "standard",
			jsFileLocation: "//server.local/revslider/wp-content/plugins/revslider/public/assets/js/",
			sliderLayout: "fullscreen",
			dottedOverlay: "none",
			delay: 5000,
			navigation: {
				keyboardNavigation: "off",
				keyboard_direction: "horizontal",
				mouseScrollNavigation: "off",
				mouseScrollReverse: "default",
				onHoverStop: "off",
				touch: {
					touchenabled: "on",
					touchOnDesktop: "off",
					swipe_threshold: 75,
					swipe_min_touches: 1,
					swipe_direction: "horizontal",
					drag_block_vertical: false
				}
				,
				arrows: {
					style: "hades",
					enable: true,
					hide_onmobile: false,
					hide_under: 778,
					hide_onleave: false,
					tmp: '<div class="tp-arr-allwrapper"><div class="tp-arr-imgholder"></div></div>',
					left: {
						h_align: "left",
						v_align: "center",
						h_offset: 50,
						v_offset: -42
					},
					right: {
						h_align: "right",
						v_align: "center",
						h_offset: 50,
						v_offset: -42
					}
				}
				,
				bullets: {
					enable: true,
					hide_onmobile: false,
					//hide_over:479,
					style: "hades",
					hide_onleave: false,
					direction: "horizontal",
					h_align: "center",
					v_align: "bottom",
					h_offset: 0,
					v_offset: 50,
					space: 10,
					tmp: '<span class="tp-bullet-image"></span>',
				}

			},
			viewPort: {
				enable: true,
				outof: "wait",
				visible_area: "80%",
				presize: true
			},
			responsiveLevels: [1240, 1024, 778, 480],
			visibilityLevels: [1240, 1024, 778, 480],
			gridwidth: [1240, 1024, 778, 480],
			gridheight: [840, 700, 700, 700],
			lazyType: "single",
			parallax: {
				type: "scroll",
				origo: "slidercenter",
				speed: 400,
				levels: [5, 10, 15, 20, 25, 30, 35, 40, 45, 46, 47, 48, 49, 50, 51, 55],
			},
			shadow: 0,
			spinner: "spinner3",
			stopLoop: "off",
			stopAfterLoops: -1,
			stopAtSlide: 1,
			shuffle: "off",
			autoHeight: "off",
			fullScreenAutoWidth: "off",
			fullScreenAlignForce: "off",
			fullScreenOffsetContainer: ".site-header",
			fullScreenOffset: "",
			disableProgressBar: "on",
			hideThumbsOnMobile: "off",
			hideSliderAtLimit: 0,
			hideCaptionAtLimit: 0,
			hideAllCaptionAtLilmit: 0,
			debugMode: false,
			fallbacks: {
				simplifyAll: "off",
				nextSlideOnWindowFocus: "off",
				disableFocusListener: false,
			}
		});
	}
	try { initSocialSharing("318") } catch (e) { }
}

function dz_rev_slider_5() {
	if (tpj("#rev_slider_1050_1").revolution === undefined) {
		revslider_showDoubleJqueryError("#rev_slider_1050_1");
	} else {
		revapi318 = tpj("#rev_slider_1050_1").show().revolution({
			sliderType: "standard",
			jsFileLocation: "revolution/js/",
			sliderLayout: "fullscreen",
			dottedOverlay: "none",
			delay: 9000,
			navigation: {
				keyboardNavigation: "off",
				keyboard_direction: "vertical",
				mouseScrollNavigation: "off",
				mouseScrollReverse: "default",
				onHoverStop: "off",
				touch: {
					touchenabled: "on",
					swipe_threshold: 75,
					swipe_min_touches: 50,
					swipe_direction: "vertical",
					drag_block_vertical: false
				}
				,
				bullets: {
					enable: true,
					hide_onmobile: true,
					//hide_under:1024,
					style: "hephaistos",
					hide_onleave: false,
					direction: "vertical",
					h_align: "right",
					v_align: "center",
					h_offset: 30,
					v_offset: 0,
					space: 5,
					tmp: ''
				}
			},
			responsiveLevels: [1240, 1024, 778, 480],
			visibilityLevels: [1240, 1024, 778, 480],
			gridwidth: [1400, 1240, 778, 480],
			gridheight: [868, 768, 960, 720],
			lazyType: "none",
			shadow: 0,
			spinner: "spinner2",
			stopLoop: "off",
			stopAfterLoops: -1,
			stopAtSlide: 1,
			shuffle: "off",
			autoHeight: "off",
			fullScreenAutoWidth: "off",
			fullScreenAlignForce: "off",
			fullScreenOffsetContainer: ".site-header",
			fullScreenOffset: "",
			disableProgressBar: "on",
			hideThumbsOnMobile: "off",
			hideSliderAtLimit: 0,
			hideCaptionAtLimit: 0,
			hideAllCaptionAtLilmit: 0,
			debugMode: false,
			fallbacks: {
				simplifyAll: "off",
				nextSlideOnWindowFocus: "off",
				disableFocusListener: false,
			}
		});
	}
}