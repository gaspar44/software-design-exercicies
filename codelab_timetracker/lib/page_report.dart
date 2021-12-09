import 'package:flutter/material.dart';

class PageReport extends StatefulWidget {
  const PageReport({Key? key}) : super(key: key);

  @override
  _PageReportState createState() => _PageReportState();
}

class _PageReportState extends State<PageReport> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("reports"),
      ),
        body : Container(

          child :  new Column(
            children: [
              buildRow(),
              Text("er Huevo")
            ],
          ),//buildRow(),
        )
    );
  }

  Widget buildRow() =>
      Row(
        children: [
          Icon(Icons.star, color:  Colors.amber,),
          Icon(Icons.star, color:  Colors.amber,),
          Icon(Icons.star, color:  Colors.amber,),
          Icon(Icons.star, color:  Colors.amber,),
          Icon(Icons.star, color:  Colors.amber,),
          Text("prueba")
        ],
      );
}
