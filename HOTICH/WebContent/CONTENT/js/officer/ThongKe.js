window.onload = function () {

var chart = new CanvasJS.Chart("chartContainer", {
	exportEnabled: true,
	animationEnabled: true,
	title:{
		text: "State Operating Funds"
	},
	legend:{
		cursor: "pointer",
		itemclick: explodePie
	},
	data: [{
		type: "pie",
		showInLegend: true,
		toolTipContent: "{name}: <strong>{y}%</strong>",
		indexLabel: "{name} - {y}%",
		click: explodePie,
		dataPoints: [
			{ y: 26, name: "School Aid", exploded: true },
			{ y: 20, name: "Medical Aid" },
			{ y: 5, name: "Debt/Capital" },
			{ y: 3, name: "Elected Officials" },
			{ y: 7, name: "University" },
			{ y: 17, name: "Executive" },
			{ y: 22, name: "Other Local Assistance"}
		]
	}]
});
chart.render();
}

function explodePie(e) {
	for(var i = 0; i < e.dataSeries.dataPoints.length; i++) {
		if(i !== e.dataPointIndex)
			e.dataSeries.dataPoints[i].exploded = false;
	}
}