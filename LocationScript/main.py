import pandas as pd
import scipy as sp
import numpy as np
import matplotlib.pyplot as plt
import LocationUtil as LU
from scipy.interpolate import interp1d


def location_to_names(locations_df, names_df, year, geo_df):
    df_new, theta = LU.turning(locations_df)
    names_resolution = len(names_df) / 2
    func = interp1d(df_new['X'].values, df_new['Y'].values)
    #print(df_new)
    x = df_new['X'].values
    evenX = LU.evenArcX(func, x[0], x[-1], names_resolution)
    print(len(evenX))
    evenY = []
    for i in evenX:
        print(i, func(i))
        evenY.append(func(i))

    gLocations = geo_df[geo_df['Year'] == year]
    gStart = [gLocations["Start_X"], gLocations["Start_Y"]]
    gEnd = [gLocations["End_X"], gLocations["End_Y"]]
    new_long, new_lat = LU.euclid_to_geo(evenX, evenY, gStart, gEnd)

    new_long_reversed = new_long.reverse()
    new_lat_reversed = new_lat.reverse()

    full_long = new_long.extend(new_long_reversed)
    full_lat = new_lat.extend(new_lat_reversed)

    return full_long, full_lat


testdf = pd.read_csv("data/test30.csv", header = None, names = ['X', 'Y'])
geodf = pd.read_csv("data/geoStartStop.csv")

#print(testdf, geodf)

names = pd.read_csv("data/SeniorWalkData.csv")
print(names.info())

names2005 = names[names["gradyear"] == 2005]
print(names2005.head())
names2005 = names2005.sort_values(by=['lastname'])
print(names2005.head())

#full_long, full_lat = location_to_names(testdf, names2005, 2005, geodf)
#print(full_long, full_lat)
#plt.figure()
#plt.plot(full_long, full_lat)

df_2007 = pd.read_csv("data/2007digitizer.csv", header = None, names = ['X', 'Y'])
names2007 = names2005 = names[names["gradyear"] == 2007]
#print(df_2007)

func = interp1d(df_2007['X'].values, df_2007['Y'].values)
x = df_2007["X"].values
y = df_2007['Y'].values
res = len(names2007) / 2
print(res)

minx = int(x[0].round())
maxx = int(x[-1].round())
badx = np.linspace(x[0], x[-1], int(res))
#print(badx)
bady = func(badx)

gLocations = geodf[geodf['Year'] == 2007]
gStart = [gLocations["Start_X"], gLocations["Start_Y"]]
gEnd = [gLocations["End_X"], gLocations["End_Y"]]

#print(badx, bady, gStart, gEnd)
new_long, new_lat = LU.euclid_to_geo(badx, bady, gStart, gEnd)
long_max = new_long[-1]
lat_max = new_lat[-1]
new_long_reversed = new_long[::-1]
#print(new_long_reversed)
new_lat_reversed = new_lat[::-1]
new_long.extend(new_long_reversed)
new_lat.extend(new_lat_reversed)
#print(len(new_long))
if len(new_long) != len(names2007):
    new_long.append(new_long[-1])
    new_lat.append(new_lat[-1])
sortedNames = names2007.sort_values("lastname")
#print(sortedNames)

fixed_long = []
for i in new_long:
    fixed_long.append(i.tolist()[0])

fixed_lat = []
for j in new_lat:
    fixed_lat.append(j.tolist()[0])

df_new = pd.DataFrame({'first_name' : sortedNames['firstname'], 'last_name' : sortedNames['lastname'], 'longitude' : fixed_long, 'latitude' : fixed_lat, 'gradyear' : 2007})
print(df_new)
plt.figure()
plt.plot(df_new['longitude'], df_new['latitude'])
#plt.axis([0,int(long_max), int(lat_max), 0])
plt.show()
df_new.to_csv(r'data/2007.csv', index = False)
print("Done")