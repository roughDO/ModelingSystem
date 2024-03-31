document.addEventListener('DOMContentLoaded', function() {
	var contentDivs = document.querySelectorAll('.content>div, .chart');
	var chart = document.getElementById('chart');

	contentDivs.forEach(function(contentDiv) {
		contentDiv.addEventListener('mouseover', function() {
			console.log(event.target.classList);
			if (event.target.classList.value.includes('TISA') || event.target.classList.value.includes('VISA') || event.target.classList.value.includes('ZISA') || event.target.classList.value.includes('KE')) {
				// 修改悬浮窗口位置
				var divLoc = document.getElementsByClassName(event.target.classList.value)[0];
				var chartLoc = document.getElementsByClassName('chart')[0];
                var chartX = divLoc.offsetLeft;
                var chartY = divLoc.offsetTop + 78;
				chartLoc.style.left = chartX + 'px';
				chartLoc.style.top = chartY + 'px';
				// 获取具体的数据列表
				// console.log(event.target.classList.value);
				var hidden_data = document.getElementsByClassName(event.target.classList.value);
				// 获取时间
				var data_now = hidden_data[0].dataset.now;
				// console.log(data_now);
				// 获取数据列表
				var data_list_raw = hidden_data[0].dataset.list;
				data_list_raw = data_list_raw.slice(2, -2);
				var items = data_list_raw.split('], [');

				var data_list = [];
				for (var i = 0; i < items.length; i++) {
					var row = items[i].split(', ').map(function(item) {
						if (item[0] === '"') {
							return item.slice(1, -1); // 去除字符串值的引号
						} else {
							return item;
						}
					});
					data_list.push(row);
				}
				// console.log(data_list[0][2]);
				// 获取指定的数据列
				var data_columnIdx = hidden_data[0].dataset.idx - 1;
				// console.log(data_columnIdx);
				// console.log(data_list[0][data_columnIdx]);
				var xData = [];
				for (var j = 0; j < data_list.length; j++) {
					xData.push(data_list[j][1]);
				}
				var yData = [];
				for (var k = 0; k < data_list.length; k++) {
					yData.push(data_list[k][data_columnIdx]);
				}

				// 读取 div 内的文本内容
			    // var text = contentDiv.innerText;
			    //
			    // // 提取文本中的数字部分
			    // var numberText = text.replace(/[^0-9.-]+/g, '');
			    //
			    // // 将提取的文本数字转换为数值
			    // var numberValue = parseFloat(numberText);
			        
			    // console.log(numberValue);  // 在控制台输出转换后的数值
				
				// 获取对应的DOM元素
				var chartDom = document.getElementById('chart');
				// 初始化ECharts实例
				var myChart = echarts.init(chartDom);
				// 定义图表配置项和数据
				var option = {
					grid: {
						containLabel: true // 设置为true时，坐标轴标签会被包含在内
					},
				    xAxis: {
				    	type: 'category',
				    	data: xData,
						boundaryGap: false, // 设置为false时，坐标轴两端留白
						axisLabel: {
				    		rotate: 45 // 旋转角度，单位为度
					    }
				    },
				    yAxis: {
				    	type: 'value'
				    },
				    series: [{
				    	data: yData,
				    	type: 'line'
				    }],
					label: {
						show: true, // 显示数值
						position: 'top' // 数值显示在数据点的顶部
					},
					dataZoom: [
						{
							type: 'slider', // 这里是关键，设置为滑动条模式
							show: true,
							xAxisIndex: [0],
							start: 0,
							end: 50
						}
					]
				};
				// 使用刚指定的配置项和数据显示图表
				myChart.setOption(option);
			}
		
			chart.style.display = 'block';
		});

		contentDiv.addEventListener('mouseout', function() {
			// 检查是否鼠标还在其他相关元素上
			var isHovering = Array.from(contentDivs).some(function(div) {
			return div.matches(':hover');
		});
      
		if (!isHovering) {
			chart.style.display = 'none';
		}
    });
  });
});


