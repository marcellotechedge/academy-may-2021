"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.CaseDistribution = void 0;
const typeorm_1 = require("typeorm");
let CaseDistribution = class CaseDistribution {
};
__decorate([
    typeorm_1.PrimaryGeneratedColumn(),
    __metadata("design:type", Number)
], CaseDistribution.prototype, "id", void 0);
__decorate([
    typeorm_1.Column("datetime"),
    __metadata("design:type", Date)
], CaseDistribution.prototype, "yearWeek", void 0);
__decorate([
    typeorm_1.Column("int"),
    __metadata("design:type", Number)
], CaseDistribution.prototype, "casesWeekly", void 0);
__decorate([
    typeorm_1.Column("int"),
    __metadata("design:type", Number)
], CaseDistribution.prototype, "deathsWeekly", void 0);
__decorate([
    typeorm_1.Column("varchar"),
    __metadata("design:type", String)
], CaseDistribution.prototype, "countriesAndTerritories", void 0);
__decorate([
    typeorm_1.Column("varchar"),
    __metadata("design:type", String)
], CaseDistribution.prototype, "geoId", void 0);
__decorate([
    typeorm_1.Column("varchar"),
    __metadata("design:type", String)
], CaseDistribution.prototype, "countryTerritoryCode", void 0);
__decorate([
    typeorm_1.Column("bigint"),
    __metadata("design:type", Number)
], CaseDistribution.prototype, "popData2019", void 0);
__decorate([
    typeorm_1.Column("varchar"),
    __metadata("design:type", String)
], CaseDistribution.prototype, "continentExp", void 0);
__decorate([
    typeorm_1.Column("decimal"),
    __metadata("design:type", Number)
], CaseDistribution.prototype, "notificationRate", void 0);
__decorate([
    typeorm_1.Column("datetime"),
    __metadata("design:type", Date)
], CaseDistribution.prototype, "tsInsert", void 0);
__decorate([
    typeorm_1.Column("datetime"),
    __metadata("design:type", Date)
], CaseDistribution.prototype, "tsUpdate", void 0);
CaseDistribution = __decorate([
    typeorm_1.Entity({ name: "CaseDistribution" })
], CaseDistribution);
exports.CaseDistribution = CaseDistribution;
//# sourceMappingURL=CaseDistribution.js.map