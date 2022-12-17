function Car(color, model, cost, fuelType) {

    this.color = color;
    this.model = model
    this.cost = cost;
    this.fuelType = fuelType
    let runningCostPerYear = 30000
    this.getCarDetails = function() {
        console.log("Color : " + this.color );
        console.log("Model : " + this.model );
        console.log("cost : " + this.cost );
        console.log("fueltype : " + this.fuelType );
        console.log("Running Cost of the car per year  : " + this.runningCostPerYear );
    }
    this.TotalCostOfOwnership = function() {
        console.log(runningCostPerYear + cost);
    }
}
let MercedesCclass =  new Car("Black", "C Class", 5000000, "Petrol" );
MercedesCclass.getCarDetails();
// MercedesCclass.runningCostPerYear= 90000;
console.log(MercedesCclass.TotalCostOfOwnership());