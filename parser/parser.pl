#!/usr/bin/perl -w
use strict;

use XML::Simple;
use Data::Dumper;
use JSON;

my $xml = new XML::Simple;
my $data = $xml->XMLin("sed2.xml");
my $file='data.json';
my @tmp;


open (my $f,">",$file) or die "Fail to open file";
	foreach $a (keys $data->{item}){
		my $title=$data->{item}->{$a}->{title};
		$title =~ s/^\s.*\:\s//;
		$title =~ s/\n//;
		my $category=$data->{item}->{$a}->{category};
		$category=~ s/^\s+//;
		$category=~ s/\n//;
		my $coord=$data->{item}->{$a}->{geolocation};
		my $tmp="item:{title:$title,category:$category,coordinates:$coord}\n";
		push (@tmp,$tmp);
		print $f @tmp;
}
close ($f);
